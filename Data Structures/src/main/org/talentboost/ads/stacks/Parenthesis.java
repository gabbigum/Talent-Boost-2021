package main.org.talentboost.ads.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class Parenthesis {
    //TODO complete implementation
    public static boolean hasDuplicates(String input) {
        Deque<Character> stack = new ArrayDeque<>();

        boolean hasDuplicate = false;
        for (int i = 0; i < input.length(); i++) {

            if (isOpeningBracket(input.charAt(i))) {
                stack.push(input.charAt(i));
            } else if (isClosingBracket(input.charAt(i))) {

                if (!stack.isEmpty()) {
                    Character currentChar = stack.peek();
                    if (isOpeningBracket(currentChar)) {
                        stack.pop();
                    } else {
                        stack.push(input.charAt(i));
                    }
                } else {
                    return false; // expression starts with )
                }
            }
        }

        return stack.isEmpty() && hasDuplicate;
    }

    private static boolean isClosingBracket(char bracket) {
        return bracket == ')';
    }

    private static boolean isOpeningBracket(char bracket) {
        return bracket == '(';
    }
}
