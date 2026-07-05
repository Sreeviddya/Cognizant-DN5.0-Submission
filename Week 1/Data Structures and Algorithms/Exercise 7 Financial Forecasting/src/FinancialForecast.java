public class FinancialForecast {

    public static double predictFutureValue(double presentValue, double[] historicalGrowthRates) {
        return predictRecursive(presentValue, historicalGrowthRates, 0);
    }

    private static double predictRecursive(double currentValue, double[] growthRates, int index) {
        if (index >= growthRates.length) {
            return currentValue;
        }
        double nextValue = currentValue * (1 + growthRates[index]);
        return predictRecursive(nextValue, growthRates, index + 1);
    }

    public static double predictFutureValueIterative(double presentValue, double[] historicalGrowthRates) {
        double value = presentValue;
        for (double rate : historicalGrowthRates) {
            value *= (1 + rate);
        }
        return value;
    }
}
