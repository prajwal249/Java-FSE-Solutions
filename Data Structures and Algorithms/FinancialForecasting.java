public class FinancialForecasting {

    /**
     * Recursive method to calculate future financial value.
     * Formula: Future Value = Present Value * (1 + Growth Rate)^Years
     * * Time Complexity: O(N) where N is the number of years.
     * Space Complexity: O(N) due to the recursive call stack.
     *
     * @param presentValue The starting capital/amount
     * @param growthRate   The annual growth rate (e.g., 0.05 for 5%)
     * @param years        The number of years to forecast
     * @return The calculated future value
     */
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        // Base Case: If years is 0, the value hasn't changed
        if (years == 0) {
            return presentValue;
        }
        
        // Recursive Case: Calculate the value for (years - 1) and apply current year's growth
        return calculateFutureValue(presentValue, growthRate, years - 1) * (1 + growthRate);
    }

    public static void main(String[] args) {
        // Initial setup for testing
        double initialInvestment = 1000.00; // $1,000 starting amount
        double annualGrowthRate = 0.05;     // 5% growth rate per year
        int forecastPeriod = 5;             // Forecast for 5 years

        System.out.println("=== Financial Forecasting Simulation ===");
        System.out.printf("Initial Investment: $%.2f%n", initialInvestment);
        System.out.printf("Estimated Annual Growth Rate: %.1f%%%n", (annualGrowthRate * 100));
        System.out.println("Forecast Period: " + forecastPeriod + " years\n");

        // Execute the recursive calculation
        double forecastedValue = calculateFutureValue(initialInvestment, annualGrowthRate, forecastPeriod);

        System.out.println("--- Forecast Result ---");
        System.out.printf("Estimated Value after %d years: $%.2f%n", forecastPeriod, forecastedValue);
        
        System.out.println("\n--- Year-by-Year Breakdown Verification ---");
        for (int i = 0; i <= forecastPeriod; i++) {
            System.out.printf("Year %d: $%.2f%n", i, calculateFutureValue(initialInvestment, annualGrowthRate, i));
        }
    }
}