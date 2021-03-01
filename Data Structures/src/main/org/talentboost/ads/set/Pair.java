package main.org.talentboost.ads.set;

import java.util.*;

//https://www.hackerrank.com/challenges/pairs/problem
public class Pair {
    // Complete the pairs function below.
    static Integer pairs(int k, Integer[] arr) {
        // O(n)

        Set<Integer> numbers = new HashSet<>(List.of(arr));
        Integer pairCounter = 0;

        for(Integer num : numbers) {
            if(numbers.contains(num + k)) {
                pairCounter++;
            }
        }

        return pairCounter;
        /* O(n^2)
        // put arr elements in different set pairs
        // check if the difference is exactly K and put it in pairs

        Set<List<Integer>> pairsSet = new HashSet<>();

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                if(i != j) {
                    if(arr[i] - arr[j] == k) {
                        pairsSet.add(List.of(arr[i], arr[j]));
                    }
                }
            }
        }
        return pairsSet.size();

         */
    }

    private static final Scanner scanner = new Scanner(System.in);

    private static Integer[] numbers = {1, 5, 3, 4, 2 };

    public static void main(String[] argv) {
        Integer difference = scanner.nextInt();
        System.out.printf("number of pairs of integers whose difference is %d: %d",difference,pairs(difference,numbers));
    }
}
