
package edu.grinnell.sortingvisualizer.events;

import java.util.List;

public interface SortEvent<T extends Comparable<T>> {
  
  /**
   * applies the associated sort event to the given list
   * @return 
   */
  <T extends Comparable<T>> void apply(T[] arr);
  
  /**
   * returns a list containing all of the indices that the associated event affects
   */
  List<Integer> getAffectedIndices();
  
  /**
   * return true if associated event should be emphasized by the visualizer/audibilizer
   */
  boolean isEmphasized();
}
 // end interface
