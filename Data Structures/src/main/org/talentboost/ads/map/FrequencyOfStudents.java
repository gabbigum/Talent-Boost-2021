package main.org.talentboost.ads.map;

import java.util.*;

//https://www.hackerearth.com/practice/data-structures/hash-tables/basics-of-hash-tables/practice-problems/algorithm/frequency-of-students/
public class FrequencyOfStudents {

    private static final Scanner scanner = new Scanner(System.in);

    //fill the main function
    public static void main(String[] argv) {

        Integer n = scanner.nextInt();
        scanner.nextLine();

        /* There is a class consisting of 'N' students . There can be many students with the same name.
        Now, you have to print the names of the students followed by there frequency as shown in the sample explanation given below.
        Output the names in the lexicographical order.
       */
        Map<String, Integer> nameFrequency = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();

            if (nameFrequency.containsKey(name)) {
                nameFrequency.put(name, nameFrequency.get(name) + 1);
            } else {
                nameFrequency.put(name, 1);
            }
        }

        List<String> result = new ArrayList<>();

        nameFrequency.entrySet().stream().forEach(names -> {
            result.add(names.getKey() + " " + names.getValue());
        });

        result.sort((o1, o2) -> {
            if (o1.charAt(0) < o2.charAt(0)) {
                return -1;
            } else if (o1.charAt(0) > o2.charAt(0)) {
                return 1;
            } else {
                return 0;
            }
        });

        for (String name : result) {
            System.out.println(name);
        }

    }

}
