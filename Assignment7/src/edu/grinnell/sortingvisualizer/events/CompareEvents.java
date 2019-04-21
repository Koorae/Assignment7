package edu.grinnell.sortingvisualizer.events;

import java.util.List;

public class CompareEvents implements SortEvent{

  int first;
  
  int second;
  
  List<Integer> indicies;
  
  public CompareEvents(int first, int second) {
    this.first = first;
    this.second = second;
    this.indicies.add(this.first);
    this.indicies.add(this.second);
  }
  
  @Override
  public void apply(Object[] arr) {
  }

  @Override
  public List<Integer> getAffectedIndicies() {
    return this.indicies;
  }

  @Override
  // compare events are not emphasized
  public boolean isEmphasized() {
    return false;
  }

}
