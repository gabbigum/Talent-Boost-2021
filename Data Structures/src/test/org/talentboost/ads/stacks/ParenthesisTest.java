package test.org.talentboost.ads.stacks;

import main.org.talentboost.ads.stacks.Parenthesis;

public class ParenthesisTest {
    public static void main(String[] args) {
        testParenthesis();

        System.out.println("SUCCESS");
    }

    public static void testParenthesis() {
        assertResult("((x+y))+z", true);
        assertResult("((x+y)+((z)))", true);
        assertResult("(x+y)", false);
        assertResult("(x", false);
        assertResult("((((x)+(y))+(z))+(y))", false);
    }

    public static void assertResult(String input, boolean expectedResult) {
        boolean res = Parenthesis.hasDuplicates(input);
        if (res != expectedResult) {
            throw new IllegalStateException("Got " + res + " for input [" + input + "]. Expected " + expectedResult);
        }
    }
}
