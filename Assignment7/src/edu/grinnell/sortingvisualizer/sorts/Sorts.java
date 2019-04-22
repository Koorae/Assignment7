package edu.grinnell.sortingvisualizer.sorts;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import edu.grinnell.sortingvisualizer.events.CompareEvents;
import edu.grinnell.sortingvisualizer.events.CopyEvents;
import edu.grinnell.sortingvisualizer.events.SortEvent;
import edu.grinnell.sortingvisualizer.events.SwapEvents;


public class Sorts {

  public static <T extends Comparable<T>> List<SortEvent<T>> selectionSort(T[] arr) {
    if (arr == null) {
      throw new IllegalStateException("Null Array");
    }
    List<SortEvent<T>> events = new ArrayList<SortEvent<T>>();
    for (int i = 0; i < arr.length - 1; i++) {
      int index = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j].compareTo(arr[index]) < 0) {
          events.add(new CompareEvents(i, j));
          index = j;
        }
      }
      T smaller = arr[index];
      arr[index] = arr[i];
      arr[i] = smaller;
      events.add(new SwapEvents(i, index));
    }
    return events;
  }

  public static <T extends Comparable<T>> List<SortEvent<T>> insertionSort(T[] arr) {
    if (arr == null) {
      throw new IllegalStateException("Null Array");
    }
    List<SortEvent<T>> events = new ArrayList<SortEvent<T>>();
    int n = arr.length;
    for (int i = 1; i < n; ++i) {
      T key = arr[i];
      int j = i - 1;

      while (j >= 0 && (key.compareTo(arr[j]) < 0)) {
        events.add(new CompareEvents(i, j));
        arr[j + 1] = arr[j];
        events.add(new CopyEvents(arr[j], j + 1));
        j = j - 1;
      }
      arr[j + 1] = key;
      events.add(new CopyEvents(key, j + 1));
    }
    return events;
  }

  public static <T extends Comparable<T>> List<SortEvent<T>> mergeSort(T[] arr) {
    List<SortEvent<T>> events = new ArrayList<SortEvent<T>>();
    mergeSortHelper(arr, 0, arr.length - 1, events);
    return events;
  }

  public static <T extends Comparable<T>> List<SortEvent<T>> mergeSortHelper(T[] arr, int start,
      int end, List<SortEvent<T>> events) {
    if (arr == null) {
      throw new IllegalStateException("Null Array");
    }
    int mid = (start + end) / 2;
    if (start < end) {
      mergeSortHelper(arr, start, mid, events);
      mergeSortHelper(arr, mid + 1, end, events);
      T[] temp = arr.clone();
      int i = start;
      int j = mid + 1;
      int b = start;
      while (i <= mid && j <= end) {
        if (temp[i].compareTo(temp[j]) <= 0) {
          arr[b] = temp[i];
          events.add(new CopyEvents(temp[i], b));
          events.add(new CompareEvents(i, j));
          i++;
        } else {
          arr[b] = temp[j];
          events.add(new CopyEvents(temp[j], b));
          events.add(new CompareEvents(i, j));
          j++;
        }
        b++;
      }
      while (i <= mid) {
        arr[b] = temp[i];
        events.add(new CopyEvents(temp[i], b));
        i++;
        b++;
      }
      while (j <= end) {
        arr[b] = temp[j];
        events.add(new CopyEvents(temp[j], b));
        j++;
        b++;
      }
    } // if
    return events;
  }

  public static <T extends Comparable<T>> List<SortEvent<T>> quickSort(T[] arr) {
    List<SortEvent<T>> events = new ArrayList<SortEvent<T>>();
    quickSortHelper(arr, 0, arr.length - 1, events);
    return events;
  }

  public static <T extends Comparable<T>> List<SortEvent<T>> quickSortHelper(T[] arr, int start,
      int end, List<SortEvent<T>> events) {
    if (arr == null) {
      throw new IllegalStateException("Null Array");
    }
    if (end - start <= 0) {
      return events;
    }
    if (end - start <= 1) {
      if (arr[start].compareTo(arr[end]) > 0) {
        T temp = arr[end];
        arr[end] = arr[start];
        arr[start] = temp;
        events.add(new SwapEvents(start, end));
      }
      events.add(new CompareEvents(start, end));
      return events;
    }
    int mid = (start + end) / 2;
    T pivot = arr[mid];
    int i = start;
    int j = end;
    while (i < j) {
      while (arr[i].compareTo(pivot) < 0) {
        events.add(new CompareEvents(i, mid));
        i++;
      }
      while (arr[j].compareTo(pivot) > 0) {
        events.add(new CompareEvents(j, mid));
        j--;
      }
      if (i < j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        events.add(new SwapEvents(i, j));
        i++;
        j--;
      }
    }
    if (start < j) {
      quickSortHelper(arr, start, j, events);
    }
    if (end > i) {
      quickSortHelper(arr, i, end, events);
    }
    return events;
  }

  public static <T extends Comparable<T>> void eventSort(T[] arr, List<SortEvent<T>> sorr) {
    for (int i = 0; i < arr.length; i++) {
      sorr.get(i).apply(arr);
    }
  }
  
  
}
