public class FinancialForecast {


    public static double futureValueRecursive(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue; 
        }
        return futureValueRecursive(currentValue, growthRate, years - 1) * (1 + growthRate);
    }

    
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
        double initialValue = 10000;     
        double growthRate = 0.08;        
        int forecastYears = 5;           

        
        double recursiveValue = futureValueRecursive(initialValue, growthRate, forecastYears);
        System.out.printf("Future Value (Recursive): Rs.%.2f\n", recursiveValue);

        
        Double[] memo = new Double[forecastYears + 1];
        double memoizedValue = futureValueMemo(initialValue, growthRate, forecastYears, memo);
        System.out.printf("Future Value (Memoized): RS.%.2f\n", memoizedValue);
    }
}


// output:
// Future Value (Recursive): Rs.14693.28
// Future Value (Memoized): RS.14693.28