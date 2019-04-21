<<<<<<< HEAD
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
=======

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
>>>>>>> branch 'master' of https://github.com/Koorae/Assignment7.git
