package edu.grinnell.sortingvisualizer.sorts;

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
    T[] Left = (T[])new Object[mid - start];
    T[] Right = (T[])new Object[end - mid];
    
    for (int i = 0; i < (mid - start); i++) {
      Left[i] = arr[i];
    }
    for (int i = 0; i < (end - mid); i++) {
      Right[i] = arr[mid + i];
    }
    
    
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
}
