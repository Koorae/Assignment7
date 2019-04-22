package edu.grinnell.sortingvisualizer.rendering;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import edu.grinnell.sortingvisualizer.audio.NoteIndices;
import edu.grinnell.sortingvisualizer.audio.Scale;
import edu.grinnell.sortingvisualizer.events.CompareEvents;
import edu.grinnell.sortingvisualizer.events.SortEvent;
import edu.grinnell.sortingvisualizer.sorts.Sorts;

/**
 * The Control Panel houses the GUI for interacting with the Sounds of Sorting application.
 */
public class ControlPanel extends JPanel {

  private static final long serialVersionUID = 3988453646682174194L;

  /** The frames-per-second that the program should render at */
  private static final int FPS = 20;

  /** The MIDI note values for the B minor pentatonic scale */
  public static final int[] bMinorPentatonicValues =
      new int[] {46, 49, 51, 53, 56, 58, 61, 63, 65, 68, 70, 73, 75, 78, 82, 85, 87};

  /** The MIDI note values for the chromatic scale */
  public static final int[] chromaticValues =
      new int[] {40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60,
          61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79};

  /**
   * Generates a list of sorting events by sorting the given array using the specified sorting
   * algorithm.
   * 
   * @param sort the name of the sorting algorithm to use
   * @param arr the array to sort
   * @return the list sorting events generated by sorting the array
   */
  private static List<SortEvent<Integer>> generateEvents(String sort, Integer[] arr) {
    switch (sort) {
      case "Selection":
        return Sorts.selectionSort(arr);
      case "Insertion":
        return Sorts.insertionSort(arr);
     /* case "Blind":
        return Sorts.blindLuckSort(arr);*/
      case "Merge":
        return Sorts.mergeSort(arr);
      case ("Quick"):
        return Sorts.quickSort(arr);
      default:
        throw new IllegalArgumentException("generateEvents");
    }
  }

  /**
   * Generates the named scale.
   * 
   * @param name the name of the scale
   * @return a new Scale object that contains the desired scale
   */
  public static Scale generateScale(String name) {
    switch (name) {
      case "Pentatonic":
        return new Scale(bMinorPentatonicValues);
      case "Chromatic":
        return new Scale(chromaticValues);
      default:
        throw new IllegalArgumentException();
    }
  }

  /**
   * @param fps the frames-per-second the simulation should run in
   * @return the period (in milliseconds) between steps of the simulation
   */
  private static int toPeriod(int fps) {
    return 1000 / fps;
  }

  private Scale scale;
  private ArrayPanel panel;
  private boolean isSorting;

  /**
   * Constructs a new ControlPanel.
   * 
   * @param notes the Notes object that this control panel manages
   * @param panel the ArrayPanel that this panel renders to
   */
  public ControlPanel(NoteIndices notes, ArrayPanel panel) {
    scale = new Scale(bMinorPentatonicValues);
    notes.initializeAndShuffle(scale.size());
    this.panel = panel;

    ///// The sort selection combo box /////
    JComboBox<String> sorts =
        new JComboBox<>(new String[] {"Selection", "Insertion", "Blind", "Merge", "Quick"});
    add(sorts);

    ///// The scale selection combo box /////
    JComboBox<String> scales = new JComboBox<>(new String[] {"Pentatonic", "Chromatic"});
    add(scales);

    ///// The make scale button /////
    JButton makeScaleButton = new JButton("Make Scale");
    makeScaleButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (!isSorting) {
          scale = generateScale((String) scales.getSelectedItem());
          notes.initializeAndShuffle(scale.size());
          ControlPanel.this.panel.repaint();
        }
      }
    });
    add(makeScaleButton);

    ///// The play button /////
    JButton playButton = new JButton("Play");
    playButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (isSorting) {
          return;
        }
        isSorting = true;

        Integer[] notesCopy = notes.notes.clone();
        List<SortEvent<Integer>> events =
            generateEvents(sorts.getSelectedItem().toString(), notesCopy);
        List<SortEvent<Integer>> compareEvents = new ArrayList<SortEvent<Integer>>();
        for (int index = 0; index < events.size(); index++) {
          if (events.get(index) instanceof CompareEvents) {
            compareEvents.add(events.get(index));
            events.remove(index);
            index--;
          } // for
        } // for
        events.addAll(compareEvents);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
          private int index = 0;

          @Override
          public void run() {
            if (index < events.size()) {
              SortEvent<Integer> event = events.get(index);
              index++;
              event.apply(notes.notes);
              List<Integer> pos = event.getAffectedIndices();
              for (Integer i : pos) {
                if (event.isEmphasized()) {
                  notes.highlightNote(i);
                } // if e isEmphasized
                scale.playNote(i, notes.isHighlighted(i));
              } // for
              panel.repaint();
            } else {
              this.cancel();
              panel.repaint();
              isSorting = false;
            }
          }
        }, 0, toPeriod(FPS));

      }
    });
    add(playButton);
  }
}
