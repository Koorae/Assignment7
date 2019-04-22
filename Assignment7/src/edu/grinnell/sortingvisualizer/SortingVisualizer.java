package edu.grinnell.sortingvisualizer;

/**
 * SortEvent implementation that represents swapping two given elements in an array.
 * 
 * @author Sam Rebelsky
 * @author Michael Spicer
 * @author Ryuta Kure
 * @author Kabir Jaine
 * 
 * @param <T>
 */

import java.awt.BorderLayout;
import javax.swing.JFrame;
import edu.grinnell.sortingvisualizer.audio.NoteIndices;
import edu.grinnell.sortingvisualizer.rendering.ArrayPanel;
import edu.grinnell.sortingvisualizer.rendering.ControlPanel;

public class SortingVisualizer {

  private static final int WIDTH = 400;
  private static final int HEIGHT = 300;

  public static void main(String[] args) throws InterruptedException {
    JFrame frame = new JFrame();
    frame.getContentPane().setLayout(new BorderLayout());
    NoteIndices notes = new NoteIndices(20);

    ArrayPanel arrayPanel = new ArrayPanel(notes, WIDTH, HEIGHT);
    ControlPanel controlPanel = new ControlPanel(notes, arrayPanel);

    frame.setTitle("Sorting Visualizer");
    frame.add(controlPanel, BorderLayout.PAGE_END);
    frame.add(arrayPanel, BorderLayout.CENTER);
    frame.pack();
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
