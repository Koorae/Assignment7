package edu.grinnell.sortingvisualizer.events;

import java.util.ArrayList;
import java.util.List;

public class SwapEvents<T> implements SortEvent<T>{

  int swap1;
  
  int swap2;
  
  List<Integer> indices = new ArrayList<Integer>();
  
  public SwapEvents(int first, int second) {
    this.swap1 = first;
    this.swap2 = second;
    this.indices.add(first);
    this.indices.add(second);
  }
  @Override
  public void apply(T[] arr) {
    T temp = arr[this.swap1];
    arr[this.swap1] = arr[this.swap2];
    arr[this.swap2] = temp;
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
