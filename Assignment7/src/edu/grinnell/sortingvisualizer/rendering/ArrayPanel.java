package edu.grinnell.sortingvisualizer.rendering;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import edu.grinnell.sortingvisualizer.audio.NoteIndices;

@SuppressWarnings("serial")
public class ArrayPanel extends JPanel {

  private NoteIndices notes;

  /**
   * Constructs a new ArrayPanel that renders the given note indices to the screen.
   * 
   * @param notes the indices to render
   * @param width the width of the panel
   * @param height the height of the panel
   */
  public ArrayPanel(NoteIndices notes, int width, int height) {
    this.notes = notes;
    this.setPreferredSize(new Dimension(width, height));
  }

  /**
   * Creates the desired graph on the panel.
   * 
   * @param graphics object g
   * @credits Thank HaoruiSun for providing guidance and inspiration on this method
   */
  @Override
  public void paintComponent(Graphics g) {
    Dimension dim = this.getPreferredSize();
    g.setColor(Color.black);
    g.fillRect(0, 0, dim.width, dim.height);
    int width = dim.width / (notes.notes.length);
    int maxheight = notes.notes.length;
    for (int i = 0; i < notes.notes.length; i++) {
      if (notes.isHighlighted(i)) {
        g.setColor(Color.white);
      } else {
        g.setColor(Color.gray);
      }
      int height = this.notes.notes[i] * dim.height / maxheight;
      g.fillRect(i * width, dim.height - height, width, height);
    } // for
    notes.clearAllHighlighted();
  }
}
