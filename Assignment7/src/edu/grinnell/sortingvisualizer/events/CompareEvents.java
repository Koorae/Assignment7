package edu.grinnell.sortingvisualizer.events;

import java.util.ArrayList;
import java.util.List;

public class CompareEvents<T> implements SortEvent<T>{

  int first;
  
  int second;
  
  List<Integer> indices = new ArrayList<Integer>();
  
  public CompareEvents(int first, int second) {
    this.first = first;
    this.second = second;
    this.indices.add(this.first);
    this.indices.add(this.second);
  }
  
  @Override
  public void apply(Object[] arr) {
  }

  @Override
  public List<Integer> getAffectedIndicies() {
    return this.indices;
  }

  @Override
  // compare events are not emphasized
  public boolean isEmphasized() {
    return false;
  }

}
