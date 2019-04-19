package edu.grinnell.sortingvisualizer.sorts;

import java.util.Random;

public class Sorts {

  public static <T extends Comparable<T>> void selectionSort(T[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      int index = i;
      for (int j = i + 1; j < arr.length; j++)
        if (arr[j].compareTo(arr[index]) < 0)
          index = j;

      T smaller = arr[index];
      arr[index] = arr[i];
      arr[i] = smaller;
    }
  }

  public static <T extends Comparable<T>> void insertionSort(T[] arr) {
    int n = arr.length;
    for (int i = 1; i < n; ++i) {
      T key = arr[i];
      int j = i - 1;

      while (j >= 0 && (key.compareTo(arr[j]) < 0)) {
        arr[j + 1] = arr[j];
        j = j - 1;
      }
      arr[j + 1] = key;
    }
  }

  public static <T extends Comparable<T>> void mergeSort(T[] arr) {
    mergeSortHelper(arr, 0, arr.length - 1);
  }

  public static <T extends Comparable<T>> void mergeSortHelper(T[] arr, int start, int end) {
    int mid = (start + end) / 2;
    if (start < end) {
      mergeSortHelper(arr, start, mid);
      mergeSortHelper(arr, mid + 1, end);
      int i = start;
      int j = mid + 1;
      while (i != j && j < end) {
        if (arr[i].compareTo(arr[j]) <= 0) {
          i++;
        } else {
          T temp = arr[j];
          int tempnum = i;
          arr[j] = arr[i];
          arr[i] = temp;
          i = j;
          j = tempnum;
          j++;
        }
      }
    } // if
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
    System.out.println();
    System.out.println();
  }
  
  public static <T extends Comparable<T>> void mergeSortHelperOther(T[] arr, int start, int end) {
    
    // print
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
    System.out.println();
    System.out.println();
  }

  public static <T extends Comparable<T>> void quickSort(T[] arr) {
    quickSortHelper(arr, 0, arr.length - 1);
  }

  public static <T extends Comparable<T>> void quickSortHelper(T[] arr, int start, int end) {
    int mid = (start + end) / 2;
    T pivot = arr[mid];
    int i = 0;
    int j = end;
    while (i <= j) {
      while (arr[i].compareTo(pivot) <= 0) {
        i++;
      }
      while (arr[j].compareTo(pivot) > 0) {
        j--;
      }
      if (i < j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
    if (start < j) {
      quickSortHelper(arr, start, j);
    }
    if (end > i) {
      quickSortHelper(arr, i, end);
    }
  }

  public static <T extends Comparable<T>> void blindLuckSort(T[] arr) {
    Random rand = new Random();
    int pos1;
    int pos2;
    while (badLuck(arr)) {
      pos1 = rand.nextInt(arr.length);
      pos2 = rand.nextInt(arr.length);
      T temp = arr[pos1];
      arr[pos1] = arr[pos2];
      arr[pos2] = temp;
    }
  }

  public static <T extends Comparable<T>> boolean badLuck(T[] arr) {
    for (int i = 0; i < arr.length - 2; i++) {
      if (arr[i].compareTo(arr[i + 1]) > 0) {
        return true;
      }
    }
    return false;
  }
}
