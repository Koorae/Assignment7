package edu.grinnell.sortingvisualizer.events;

import java.util.ArrayList;
import java.util.List;


/**
 * SortEvent implementation class representing the setting of an array's index, des, to a given
 * value, val.
 * 
 * @author Michael Spicer
 * @author Ryuta Kure
 * @author Kabir Jaine
 *
 * @param <T>
 */
public class CopyEvents<T> implements SortEvent<T> {

  T val;

  int des;

  List<Integer> indices = new ArrayList<Integer>();

  public CopyEvents(T value, int destination) {
    this.val = value;
    this.des = destination;
  }

  @Override
  public void apply(T[] arr) {
    arr[des] = val;
  }

  @Override
  public List<Integer> getAffectedIndices() {
    this.indices.add(this.des);
    return this.indices;
  }

  @Override
  public boolean isEmphasized() {
    return true;
  }
}
