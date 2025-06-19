public class FinancialForecast {

    // Recursive method to calculate future value
    public static double futureValueRecursive(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue; // base case
        }
        return futureValueRecursive(currentValue, growthRate, years - 1) * (1 + growthRate);
    }

    // Optimized using Memoization (caching results)
    public static double futureValueMemo(double currentValue, double growthRate, int years, Double[] memo) {
        if (years == 0) {
            return currentValue;
        }
        if (memo[years] != null) {
            return memo[years];
        }
        memo[years] = futureValueMemo(currentValue, growthRate, years - 1, memo) * (1 + growthRate);
        return memo[years];
    }

    public static void main(String[] args) {
        double initialValue = 10000;     // Starting value (e.g., Rs. 10,000)
        double growthRate = 0.08;        // 8% annual growth
        int forecastYears = 5;           // Forecast for 5 years

        // Plain Recursion
        double recursiveValue = futureValueRecursive(initialValue, growthRate, forecastYears);
        System.out.printf("Future Value (Recursive): Rs.%.2f\n", recursiveValue);

        // Optimized Recursion with Memoization
        Double[] memo = new Double[forecastYears + 1];
        double memoizedValue = futureValueMemo(initialValue, growthRate, forecastYears, memo);
        System.out.printf("Future Value (Memoized): RS.%.2f\n", memoizedValue);
    }
}


// output:
// Future Value (Recursive): Rs.14693.28
// Future Value (Memoized): RS.14693.28