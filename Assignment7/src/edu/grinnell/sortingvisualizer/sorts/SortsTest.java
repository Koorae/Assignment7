package edu.grinnell.sortingvisualizer.sorts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.util.Random;

class SortsTest {
  // +--------+
  // | Fields |-----------------------
  // +--------+

  static Random rand = new Random();

  // +-------+
  // | Tests |-----------------------
  // +-------+
  
  Integer[] empty = new Integer[0];
  Integer[] nums = {9, 5, 6, 2, 4, 3, 1, 1};
  Integer[] numsBackwards = {9, 6, 5, 4, 3, 2, 1, 1};
  Integer[] numsSorted = {1, 1, 2, 3, 4, 5, 6, 9};
  Integer[] copy = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3};
  Integer[] copyBackwards = {3, 3, 3, 3, 3, 2, 2, 2, 2, 1, 1, 1, 1, 0, 0, 0};
 
  // Check normal case array
  @Test
  void testArray() {
    checkInsertionSort(numsSorted, nums);
    checkSelectionSort(numsSorted, nums);
    checkMergeSort(numsSorted, nums);
    checkQuickSort(numsSorted, nums);
  }
  
  //Check all the same element
  @Test
  void testCopyArray() {
    checkInsertionSort(copy, copyBackwards);
    checkSelectionSort(copy, copyBackwards);
    checkMergeSort(copy, copyBackwards);
    checkQuickSort(copy, copyBackwards);
  }

  
  // Check empty array
  @Test
  void testEmptyArray() {
    checkInsertionSort(empty);
    checkSelectionSort(empty);
    checkMergeSort(empty);
    checkQuickSort(empty);
  }

  // Test Ordered
  @Test 
  void testOrderedArray() {
    checkInsertionSort(numsSorted, numsSorted);
    checkSelectionSort(numsSorted, numsSorted);
    checkMergeSort(numsSorted, numsSorted);
    checkQuickSort(numsSorted, numsSorted);
  } // testOrdered Array
  
  // Test Backwards
  @Test 
  void testBackwardsArray() {
    checkInsertionSort(numsSorted, numsBackwards);
    checkSelectionSort(numsSorted, numsBackwards);
    checkMergeSort(numsSorted, numsBackwards);
    checkQuickSort(numsSorted, numsBackwards);
  } // testOrdered Array
  
  // Test Random
  @Test 
  void testRandomArray() {

    // create an Integer array of random size and of elements of the index
    Integer[] randArray = new Integer[rand.nextInt(20)];
    for (int i = 0; i < randArray.length; i++) {
      randArray[i] = i;
    } // for

    for (int i = 0; i < 10; i++) {
      checkInsertionSort(randArray);
      checkSelectionSort(randArray);
      checkMergeSort(randArray);
      checkQuickSort(randArray);
    }
  }

  // +---------+
  // | Helpers | ------------------------------------------------
  // +---------+

  /**
   * Swap two values in an array.
   */
  public static void swap(Integer[] values, int i, int j) {
    Integer temp = values[i];
    values[i] = values[j];
    values[j] = temp;
  } // swap

  /**
   * Randomly permute an array.
   */
  public static void randomlyPermute(Integer[] values) {
    for (int i = 0; i < values.length; i++) {
      swap(values, i, rand.nextInt(values.length));
    } // for
  } // randomlyPermute(T[])

  /**
   * Test selectionSort, given an expected result
   */
  void checkSelectionSort(Integer[] expected) {
    Integer[] copy = expected.clone();
    randomlyPermute(copy);
    Sorts.selectionSort(copy);
    assertArrayEquals(expected, copy);
  } // checkQuicksort
  
  /**
   * Test selectionSort, given an expected result and input array
   */
  void checkSelectionSort(Integer[] expected, Integer[] values) {
    Sorts.selectionSort(values);
    assertArrayEquals(expected, values);
  } // checkQuicksort
  
  /**
   * Test insertionSort, given an expected result
   */
  void checkInsertionSort(Integer[] expected) {
    Integer[] copy = expected.clone();
    randomlyPermute(copy);
    Sorts.insertionSort(copy);
    assertArrayEquals(expected, copy);
  } // checkQuicksort
  
  /**
   * Test insertionSort, given an expected result and input array
   */
  void checkInsertionSort(Integer[] expected, Integer[] values) {
    Sorts.insertionSort(values);
    assertArrayEquals(expected, values);
  } // checkQuicksort
  
  /**
   * Test insertionSort, given an expected result
   */
  void checkQuickSort(Integer[] expected) {
    Integer[] copy = expected.clone();
    randomlyPermute(copy);
    Sorts.quickSort(copy);
    assertArrayEquals(expected, copy);
  } // checkQuicksort
  
  /**
   * Test insertionSort, given an expected result and input array
   */
  void checkQuickSort(Integer[] expected, Integer[] values) {
    Sorts.quickSort(values);
    assertArrayEquals(expected, values);
  } // checkQuicksort
  
  /**
   * Test mergeSort, given an expected result
   */
  void checkMergeSort(Integer[] expected) {
    Integer[] copy = expected.clone();
    randomlyPermute(copy);
    Sorts.insertionSort(copy);
    assertArrayEquals(expected, copy);
  } // checkQuicksort
  
  /**
   * Test insertionSort, given an expected result and input array
   */
  void checkMergeSort(Integer[] expected, Integer[] values) {
    Sorts.mergeSort(values);
    assertArrayEquals(expected, values);
  } // checkQuicksort
}
