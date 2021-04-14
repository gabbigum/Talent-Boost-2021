package main.com.vmware.talentboost.algorithms.sort;

public class InsertionSort {

    public static void insertionSort(int[] array) {
        for(int i = 1; i < array.length; i++) {
            int value = array[i];
            int hole = i;

            while(hole > 0 && array[hole-1] > value) {
                array[hole] = array[hole-1];
                hole--;
            }

            array[hole] = value;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {5, 3, 6, 1, 10, 4, 9};
        insertionSort(numbers);
        for (int num : numbers) {
            System.out.println(num);
        }

    }
}
