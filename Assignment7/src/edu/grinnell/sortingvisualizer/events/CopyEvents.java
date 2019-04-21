package edu.grinnell.sortingvisualizer.events;

import java.util.ArrayList;
import java.util.List;

public class CopyEvents<T> implements SortEvent<T> {

  T val;
  
  int des;
  
  List<Integer> indices = new ArrayList<Integer>();

  public CopyEvents(T value, int destination) {
    this.val = value;
    this.des = destination;
    this.indices.add(this.des);
  }

  @Override
  public void apply(T[] arr) {
    arr[des] = val;
  }

  @Override
  public List<Integer> getAffectedIndicies() {
    return this.indices;
  }

  @Override
  public boolean isEmphasized() {
    return true;
  }
}
