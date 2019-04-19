package edu.grinnell.sortingvisualizer.sorts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class SortsTest {
  Integer[] nums = {9, 5,8, 6, 2, 4, 3, 1, 1};
  Integer[] correct = {1, 1, 2, 3, 4, 5, 6, 8, 9};

  /*
  @Test
  void sStest() {
    Sorts.selectionSort(nums);
    for (int i = 0; i < nums.length; i++) {
      System.out.println(correct[i] + "      " + nums[i]);
      assertEquals(correct[i], nums[i]);
    }
  }
  
  @Test
  void iStest() {
    Sorts.insertionSort(nums);
    for (int i = 0; i < nums.length; i++) {
      System.out.println(correct[i] + "      " + nums[i]);
      assertEquals(correct[i], nums[i]);
    }
  }
  */
  
  @Test
  void mStest() {
    Sorts.mergeSort(nums);
    for (int i = 0; i < nums.length; i++) {
      System.out.println(correct[i] + "      " + nums[i]);
    }
    for (int i = 0; i < nums.length; i++) {
      assertEquals(correct[i], nums[i]);
    }
  }

  @Test
  void qStest() {
    Sorts.quickSort(nums);
    for (int i = 0; i < nums.length; i++) {
      System.out.println(correct[i] + "      " + nums[i]);
    }
    for (int i = 0; i < nums.length; i++) {
      assertEquals(correct[i], nums[i]);
    }
  }
  
  void rStest() {
    Sorts.blindLuckSort(nums);
    for (int i = 0; i < nums.length; i++) {
      System.out.println(correct[i] + "      " + nums[i]);
    }
    for (int i = 0; i < nums.length; i++) {
      assertEquals(correct[i], nums[i]);
    }
  }
}
