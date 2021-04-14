public class NumberPrinter {
    private NumberCalculator numberCalculator = new FizzBuzzCalculator();
    private Printer printer = new ConsolePrinter();

    public void printNumbers(int limit) {
        if (limit < 1) {
            throw new RuntimeException("limit must be >= 1");
        }
        for (int i = 1; i <= limit; i++) {
            try {
                printer.print(numberCalculator.calculate(i));
            } catch (Exception e) {
                // noop
            }
        }
    }
}
