import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzCalculatorTest {

    private FizzBuzzCalculator fizzBuzzCalculator;

    @Before
    public void setup() {
        fizzBuzzCalculator = new FizzBuzzCalculator();
    }

    @Test
    public void testIfDivisibleByNumberBiggerThanMaxInt() {
        fizzBuzzCalculator.calculate(Integer.MAX_VALUE + 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIfDivisibleByZeroReturnsZero() {
        fizzBuzzCalculator.calculate(0);
    }

    @Test
    public void testIfDivisibleByThreeReturnsFizz() {
        String expected = "Fizz";
        String actual = fizzBuzzCalculator.calculate(3);

        assertEquals("Calculator should return Fizz", expected, actual);
    }

    @Test
    public void testIfDivisibleByFourReturnsFour() {
        String expected = "4";
        String actual = fizzBuzzCalculator.calculate(4);

        assertEquals("Calculator should return 4", expected, actual);
    }


    @Test
    public void testIfDivisibleBy5ReturnsBuzz() {
        String expected = "Buzz";
        String actual = fizzBuzzCalculator.calculate(5);

        assertEquals("Calculator should return Buzz", expected, actual);
    }

    @Test
    public void testIfDivisibleBy15ReturnsFizzBuzz() {
        String expected = "FizzBuzz";
        String actual = fizzBuzzCalculator.calculate(15);

        assertEquals("Calculator should return FizzBuzz", expected, actual);
    }

    @Test
    public void testIfDivisibleByNegativeNumber() {
        String expected = "Fizz";
        String actual = fizzBuzzCalculator.calculate(3);

        assertEquals("Calculator should return Fizz", expected, actual);
    }
}
