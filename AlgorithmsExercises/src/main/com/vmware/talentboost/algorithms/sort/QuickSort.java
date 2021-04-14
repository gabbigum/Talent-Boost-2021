package main.com.vmware.talentboost.algorithms.sort;

/**
 * Task: There is a bug in the quick sort implementation bellow. Find it and fix
 * it!
 * <p>
 * Then implement the {@link #quickSelect(int[], int)} and {@link #partialSort(int[], int, int)}
 * methods.
 */
public class QuickSort {

   /**
    * Sorts the provided array using the quick sort algorithm.
    *
    * @param array Integer array. Cannot be {@code null};
    */
   public static void sort(int[] array) {
      if (array == null) {
         throw new IllegalArgumentException("The provided collection is null.");
      }
      sort(array, 0, array.length - 1);
   }

   /**
    * Provided and integer array and an index n, return the nth smallest value in that
    * array as if it was sorted. This method might rearrange the elements in the provided
    * array.
    *
    * @param array Integer array. Cannot be {@code null};
    * @param n     non-negative integet. Value must be between 0 and the length of the
    *              provided array.
    * @return The value of the nth element in the array, as if it was sorted.
    */
   public static int quickSelect(int[] array, int n) {
      if (array == null) {
         throw new IllegalArgumentException("The provided collection is null.");
      }
      if (n < 0) {
         throw new IllegalArgumentException("Cannot search for negative index.");
      }
      if (n > array.length) {
         throw new IllegalArgumentException("The length of the provided array is less " +
                 "than the searched index.\nArray length: " + array.length + "\n" +
                 "Searched index: " + n);
      }
      // Hint: use partition
      throw new UnsupportedOperationException("Not implemented yet.");
   }

   /**
    * Provided an integer array, offset and limit, sort only elements from
    * position 'offset' to position 'offset + limit'. If 'offset + limit' is
    * bigger than the size of the array, sort all the array from position
    * 'offset' onwards. The order of the elements outside that range is non
    * deterministic.
    *
    * @param array  Integer array. Cannot be {@code null};
    * @param offset non-negative integer. Value must be between 0 and the length
    *               of the provided array.
    * @param limit  non-negative integer.
    */
   public static void partialSort(int[] array, int offset, int limit) {
      if (array == null) {
         throw new IllegalArgumentException("The provided collection is null.");
      }
      if (offset >= array.length || offset < 0) {
         throw new IllegalArgumentException("The offset must be between 0 and " + (array.length - 1));
      }
      if (limit < 0) {
         throw new IllegalArgumentException("The limit cannot be less than 0.");
      }
      // Hint: use quickSelect
      throw new UnsupportedOperationException("Not implemented yet.");
   }

   private static void sort(int[] array, int left, int right) {
      if (left < right) {
         int p = partition(array, left, right);
         sort(array, left, p - 1);
         sort(array, p + 1, right);
      }
   }

   private static int partition(int[] array, int left, int right) {
      int pivotIndex = choosePivot(left, right);

      // we put the pivot at the end
      swap(array, pivotIndex, right);

      int pivotIndexAfterPartition = left;
      for (int i = left; i <= right; i++) {
         if (array[i] < array[pivotIndex]) {
            swap(array, i, pivotIndexAfterPartition);
            pivotIndexAfterPartition++;
         }
      }

      // put the pivot at its right place
      swap(array, pivotIndexAfterPartition, right);
      return pivotIndexAfterPartition;
   }

   private static int choosePivot(int left, int right) {
      return left + (right - left) / 2;
   }

   private static void swap(int[] array, int i, int j) {
      int tmp = array[i];
      array[i] = array[j];
      array[j] = tmp;
   }
}
