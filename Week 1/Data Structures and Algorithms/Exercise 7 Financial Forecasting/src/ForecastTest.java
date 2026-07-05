public class ForecastTest {
    public static void main(String[] args) {
        double presentValue = 1000.0;
        double[] growthRates = {0.05, 0.08, 0.06, 0.10};

        System.out.println("Present value: $" + presentValue);
        System.out.print("Historical growth rates: ");
        for (double r : growthRates) {
            System.out.print((r * 100) + "% ");
        }
        System.out.println();

        double recursiveResult = FinancialForecast.predictFutureValue(presentValue, growthRates);
        System.out.println("\nRecursive result: $" + String.format("%.2f", recursiveResult));

        double iterativeResult = FinancialForecast.predictFutureValueIterative(presentValue, growthRates);
        System.out.println("Iterative result: $" + String.format("%.2f", iterativeResult));

        System.out.println("\nResults match: " + (Math.abs(recursiveResult - iterativeResult) < 0.001));
    }
}
