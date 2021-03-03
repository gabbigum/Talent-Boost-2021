package main.com.vmware.talentboost.algorithms.sort;

public class BubbleSort {

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {5, 3, 6, 1, 10, 4, 9};
        bubbleSort(numbers);
        for (int num : numbers) {
            System.out.println(num);
        }

    }
}
