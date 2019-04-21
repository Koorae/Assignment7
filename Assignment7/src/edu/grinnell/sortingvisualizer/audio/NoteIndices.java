package edu.grinnell.sortingvisualizer.audio;

import java.util.Random;

/**
 * A collection of indices into a Scale object. These indices are the subject of the various sorting
 * algorithms in the program.
 */
public class NoteIndices {

  Integer[] notes;
  Boolean[] hl;

  /**
   * @param n the size of the scale object that these indices map into
   */
  public NoteIndices(int n) {
    this.notes = new Integer[n];
    this.hl = new Boolean[n];
  }

  /**
   * Reinitializes this collection of indices to map into a new scale object of the given size. The
   * collection is also shuffled to provide an initial starting point for the sorting process.
   * 
   * @param n the size of the scale object that these indices map into
   */
  public void initializeAndShuffle(int n) {
    Random random = new Random();
    this.notes = new Integer[n];
    this.hl = new Boolean[n];
    int rand;
    for (int i = 0; i < n; i++) {
      this.notes[i] = 2 * i;
      this.hl[i] = false;
    }
    for (int i = 0; i < n; i++) {
      rand = random.nextInt(n);
      Integer temp = this.notes[i];
      this.notes[i] = this.notes[rand];
      notes[rand] = temp;
    }
  }

  /** @return the indices of this NoteIndices object */
  public Integer[] getNotes() {
    return this.notes;
  }

  /**
   * Highlights the given index of the note array
   * 
   * @param index the index to highlight
   */
  public void highlightNote(int index) {
    // TODO: fill me in
  }

  /** @return true if the given index is highlighted */
  public boolean isHighlighted(int index) {
    // TODO: fill me in
    return false;
  }

  /** Clears all highlighted indices from this collection */
  public void clearAllHighlighted() {
    // TODO: fill me in
  }
}
