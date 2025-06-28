import java.util.Scanner;

/**
 * PayMoney Transaction Tracker Solution
 * Problem: Find at which transaction the cumulative sum reaches or exceeds target values
 * Algorithm: Linear scan with cumulative sum tracking
 * Time Complexity: O(n * t) where n = transactions, t = targets
 * Space Complexity: O(1)
 */
public class PayMoneyTransactionTracker {
    
    /**
     * Main method to solve PayMoney problem
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input transaction array size
        System.out.println("enter the size of transaction array");
        int size = scanner.nextInt();
        
        // Input transaction values
        int[] transactions = new int[size];
        System.out.println("enter the values of array");
        for (int i = 0; i < size; i++) {
            transactions[i] = scanner.nextInt();
        }
        
        // Input number of targets
        System.out.println("enter the total no of targets that needs to be achieved");
        int numTargets = scanner.nextInt();
        
        // Process each target
        for (int t = 0; t < numTargets; t++) {
            System.out.println("enter the value of target");
            int target = scanner.nextInt();
            
            int result = findTransactionForTarget(transactions, target);
            
            if (result == -1) {
                System.out.println("Given target is not achieved");
            } else {
                System.out.println("Target achieved after " + result + " transactions");
            }
        }
        
        scanner.close();
    }
    
    /**
     * Helper method to find which transaction achieves the target
     * @param transactions Array of transaction amounts
     * @param target Target amount to achieve
     * @return Transaction number (1-indexed) or -1 if not achievable
     */
    private static int findTransactionForTarget(int[] transactions, int target) {
        int cumulativeSum = 0;
        
        // Iterate through transactions and calculate cumulative sum
        for (int i = 0; i < transactions.length; i++) {
            cumulativeSum += transactions[i];
            
            // Check if target is achieved
            if (cumulativeSum >= target) {
                return i + 1; // Return 1-indexed position
            }
        }
        
        return -1; // Target not achieved
    }
    
    /**
     * Method to run test cases
     */
    public static void runTestCases() {
        System.out.println("=".repeat(50));
        System.out.println("RUNNING PAYMONEY TEST CASES");
        System.out.println("=".repeat(50));
        
        // Test Case 1: From problem statement
        System.out.println("\nTest Case 1:");
        int[] transactions1 = {20, 12, 31};
        System.out.println("Transactions: [20, 12, 31]");
        
        // Target 21
        int result1 = findTransactionForTarget(transactions1, 21);
        System.out.println("Target 21: " + 
            (result1 == -1 ? "Not achieved" : "Target achieved after " + result1 + " transactions"));
        
        // Target 19
        int result2 = findTransactionForTarget(transactions1, 19);
        System.out.println("Target 19: " + 
            (result2 == -1 ? "Not achieved" : "Target achieved after " + result2 + " transactions"));
        
        // Test Case 2: From problem statement
        System.out.println("\nTest Case 2:");
        int[] transactions2 = {100};
        System.out.println("Transactions: [100]");
        
        // Target 101
        int result3 = findTransactionForTarget(transactions2, 101);
        System.out.println("Target 101: " + 
            (result3 == -1 ? "Given target is not achieved" : "Target achieved after " + result3 + " transactions"));
        
        // Additional Test Cases
        System.out.println("\nAdditional Test Case 3:");
        int[] transactions3 = {10, 5, 15, 20, 8};
        System.out.println("Transactions: [10, 5, 15, 20, 8]");
        
        int[] targets = {10, 15, 30, 50, 58, 60};
        for (int target : targets) {
            int result = findTransactionForTarget(transactions3, target);
            System.out.println("Target " + target + ": " + 
                (result == -1 ? "Not achieved" : "Achieved after " + result + " transactions"));
        }
        
        // Edge Case: Empty array
        System.out.println("\nEdge Case - Empty Array:");
        int[] emptyTransactions = {};
        int result4 = findTransactionForTarget(emptyTransactions, 10);
        System.out.println("Target 10 with empty array: " + 
            (result4 == -1 ? "Not achieved" : "Achieved after " + result4 + " transactions"));
    }
    
    /**
     * Utility method to validate input
     */
    private static boolean validateInput(int[] transactions, int target) {
        if (transactions == null || transactions.length == 0) {
            System.out.println("Error: Transaction array is empty!");
            return false;
        }
        
        if (target <= 0) {
            System.out.println("Error: Target must be positive!");
            return false;
        }
        
        for (int transaction : transactions) {
            if (transaction <= 0) {
                System.out.println("Error: All transactions must be positive!");
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Enhanced version with input validation
     */
    public static void solveWithValidation() {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.println("enter the size of transaction array");
            int size = scanner.nextInt();
            
            if (size <= 0) {
                System.out.println("Error: Array size must be positive!");
                return;
            }
            
            int[] transactions = new int[size];
            System.out.println("enter the values of array");
            for (int i = 0; i < size; i++) {
                transactions[i] = scanner.nextInt();
            }
            
            System.out.println("enter the total no of targets that needs to be achieved");
            int numTargets = scanner.nextInt();
            
            if (numTargets <= 0) {
                System.out.println("Error: Number of targets must be positive!");
                return;
            }
            
            for (int t = 0; t < numTargets; t++) {
                System.out.println("enter the value of target");
                int target = scanner.nextInt();
                
                if (validateInput(transactions, target)) {
                    int result = findTransactionForTarget(transactions, target);
                    
                    if (result == -1) {
                        System.out.println("Given target is not achieved");
                    } else {
                        System.out.println("Target achieved after " + result + " transactions");
                    }
                }
            }
            
        } catch (Exception e) {
            System.out.println("Error: Invalid input format!");
        } finally {
            scanner.close();
        }
    }
}
