public class FizzBuzzCalculator implements NumberCalculator {
    private static final int FIVE = 5;
    private static final int THREE = 3;

    public String calculate(int number) {

        if(number == 0) {
            throw new IllegalArgumentException("Cannot calculate fizzbuzz for 0.");
        }

        if (isDivisibleBy(number, THREE) && isDivisibleBy(number, FIVE)) {
            return "FizzBuzz";
        }

        if (isDivisibleBy(number, THREE)) {
            return "Fizz";
        }

        if (isDivisibleBy(number, FIVE)) {
            return "Buzz";
        }

        return "" + number;
    }

    private boolean isDivisibleBy(int dividend, int divisor) {

        return dividend % divisor == 0;
    }
}
