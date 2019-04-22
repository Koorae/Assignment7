
package edu.grinnell.sortingvisualizer.events;

import java.util.List;

public interface SortEvent<T> {

  /**
   * applies this sort event to the given list.
   * 
   * @param arr the array that the event changes or is applied to
   */
  public void apply(T[] arr);

  /**
   * returns a list containing all of the indices that this event affects.
   * 
   * @return List of Integers representing the affected indices associated with the given event
   */
  List<Integer> getAffectedIndices();

  /**
   * return true if this event should be emphasized by the visualizer/audibilizer.
   * 
   * @return boolean describing whether or not the event is emphasized (with highlighting and sound
   *         in the rendering)
   */
  boolean isEmphasized();
}

