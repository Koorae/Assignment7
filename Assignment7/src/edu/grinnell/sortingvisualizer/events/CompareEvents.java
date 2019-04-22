package edu.grinnell.sortingvisualizer.events;

import java.util.ArrayList;
import java.util.List;

/**
 * SortEvent class that is helpful in describing which indices were compared during the logged
 * sorting process.
 *
 * @param <T>
 */
public class CompareEvents<T> implements SortEvent<T> {

  int first;

  int second;

  List<Integer> indices = new ArrayList<Integer>();

  public CompareEvents(int first, int second) {
    this.first = first;
    this.second = second;
  }

  @Override
  public void apply(Object[] arr) {}

  @Override
  public List<Integer> getAffectedIndices() {
    this.indices.add(this.first);
    this.indices.add(this.second);
    return this.indices;
  }

  @Override
  public boolean isEmphasized() {
    return false;
  }

}
