
package edu.grinnell.sortingvisualizer.events;

import java.util.List;

public interface SortEvent <T> {
  
  // applies this sort event to the given list.
  public void apply (T[] arr);
  
  // returns a list containing all of the indices that this event affects.
  List<Integer> getAffectedIndicies();
  
  // return true if this event should be emphasized by the visualizer/audibilizer.
  boolean isEmphasized();
}