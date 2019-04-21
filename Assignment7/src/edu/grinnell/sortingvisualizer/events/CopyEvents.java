package edu.grinnell.sortingvisualizer.events;

import java.util.List;

public class CopyEvents<T> implements SortEvent<T> {

  T val;
  
  int des;

  List<Integer> indicies;

  public CopyEvents(T value, int destination) {
    this.val = value;
    this.des = destination;
    this.indicies.add(this.des);
  }

  @Override
  public void apply(T[] arr) {
    arr[des] = val;
  }

  @Override
  public List<Integer> getAffectedIndicies() {
    return this.indicies;
  }

  @Override
  public boolean isEmphasized() {
    return true;
  }
}
