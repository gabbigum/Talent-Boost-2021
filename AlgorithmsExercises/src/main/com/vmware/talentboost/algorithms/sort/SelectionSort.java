package main.com.vmware.talentboost.algorithms.sort;

public class SelectionSort {

    public static void selectionSort(int[] array) {
        int lowestIndex;

        for (int i = 0; i < array.length; i++) {
            lowestIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[lowestIndex] > array[j]) {
                    lowestIndex = j;
                }
            }
            swap(array, lowestIndex, i);
        }
    }

    public static int findNth(int[] array, int n) {
        if (array == null) {
            throw new IllegalArgumentException("The provided array is null!");
        }
        if (n < 0) {
            throw new IllegalArgumentException("Cannot search for negative index.");
        }
        if (n > array.length) {
            throw new IllegalArgumentException("The length of the provided array is less " +
                    "than the searched index.\nArray length: " + array.length + "\n" +
                    "Searched index: " + n);
        }

        int minIndex;

        for(int i = 0; i < array.length; i++) {
            minIndex = i;
            for(int j = i+1; j < array.length; j++) {
                if(array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            if(i != minIndex) {
                swap(array, i, minIndex);
            }
            if(i == n) {
                break;
            }
        }

        return array[n];
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 6, 3, 2};

        int nth = findNth(arr, 3);
        System.out.println(nth);


    }
}
