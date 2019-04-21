<<<<<<< HEAD
package edu.grinnell.sortingvisualizer.events;

import java.util.List;

public class CompareEvents<T> implements SortEvent<T>{

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
=======
package edu.grinnell.sortingvisualizer.events;

public class CompareEvents <T extends Comparable<T>> implements SortEvent <T extends Comparable<T>>{

  
}
>>>>>>> branch 'master' of https://github.com/Koorae/Assignment7.git
