package edu.grinnell.sortingvisualizer.sorts;

public class Exp {
  public static void main(String[] args) {
    int[] arr = {1,2,3,4,5};
    int[] temp = arr;
    arr[0] = 10;
    System.out.println(temp[0]);
  }
}
