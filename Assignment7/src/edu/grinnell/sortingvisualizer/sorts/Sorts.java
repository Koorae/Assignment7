package sorts;

public class Sorts {

  public static <T extends Comparable<T>> void selectionSort(T[] arr){

    for (int i = 0; i < arr.length - 1; i++)
    {
      int index = i;
      for (int j = i + 1; j < arr.length; j++)
        if (arr[j].compareTo(arr[index]) < 0)
          index = j;

      T smaller = arr[index];  
      arr[index] = arr[i];
      arr[i] = smaller;
    }
  }
  
  public static <T extends Comparable<T>> void insertionSort(T[] arr) 
  {  
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
 
}
