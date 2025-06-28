import java.util.*;

/**
 * Currency Denomination Calculator Solution
 * Problem: Find minimum number of notes to pay exact amount using greedy algorithm
 * Algorithm: Greedy approach - use highest denomination first
 * Time Complexity: O(n log n) for sorting + O(n) for processing
 * Space Complexity: O(n) for sorted array
 */
public class CurrencyDenominationCalculator {
    
    /**
     * Main method to solve Currency problem
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input currency denominations size
        System.out.println("enter the size of currency denominations");
        int size = scanner.nextInt();
        
        // Input denomination values
        int[] denominations = new int[size];
        System.out.println("enter the currency denominations value");
        for (int i = 0; i < size; i++) {
            denominations[i] = scanner.nextInt();
        }
        
        // Input amount to pay
        System.out.println("enter the amount you want to pay");
        int amount = scanner.nextInt();
        
        // Calculate and display result
        calculateMinimumNotes(denominations, amount);
        
        scanner.close();
    }
    
    /**
     * Core method to calculate minimum notes using greedy algorithm
     * @param denominations Array of available denominations
     * @param amount Amount to be paid
     */
    public static void calculateMinimumNotes(int[] denominations, int amount) {
        // Sort denominations in descending order for greedy approach
        Integer[] sortedDenominations = new Integer[denominations.length];
        for (int i = 0; i < denominations.length; i++) {
            sortedDenominations[i] = denominations[i];
        }
        Arrays.sort(sortedDenominations, Collections.reverseOrder());
        
        System.out.println("Your payment approach in order to give min no of notes will be");
        
        int remainingAmount = amount;
        boolean paymentMade = false;
        
        // Apply greedy algorithm: use largest denomination first
        for (int denomination : sortedDenominations) {
            if (remainingAmount >= denomination) {
                int notesNeeded = remainingAmount / denomination;
                System.out.println(denomination + ":" + notesNeeded);
                remainingAmount = remainingAmount % denomination;
                paymentMade = true;
            }
        }
        
        // Handle edge cases
        if (remainingAmount > 0) {
            System.out.println("Warning: Exact payment not possible. Remaining amount: " + remainingAmount);
        }
        
        if (!paymentMade) {
            System.out.println("Payment not possible with given denominations.");
        }
    }
    
    /**
     * Alternative method that returns result as data structure
     */
    public static Map<Integer, Integer> calculateMinimumNotesAsMap(int[] denominations, int amount) {
        Map<Integer, Integer> result = new LinkedHashMap<>();
        
        // Sort denominations in descending order
        Integer[] sortedDenominations = new Integer[denominations.length];
        for (int i = 0; i < denominations.length; i++) {
            sortedDenominations[i] = denominations[i];
        }
        Arrays.sort(sortedDenominations, Collections.reverseOrder());
        
        int remainingAmount = amount;
        
        for (int denomination : sortedDenominations) {
            if (remainingAmount >= denomination) {
                int notesNeeded = remainingAmount / denomination;
                result.put(denomination, notesNeeded);
                remainingAmount = remainingAmount % denomination;
            }
        }
        
        return result;
    }
    
    /**
     * Method to run all test cases
     */
    public static void runTestCases() {
        System.out.println("=".repeat(60));
        System.out.println("RUNNING CURRENCY DENOMINATION TEST CASES");
        System.out.println("=".repeat(60));
        
        // Test Case 1: From problem statement
        System.out.println("\nTest Case 1:");
        int[] denominations1 = {5, 1, 10};
        int amount1 = 12;
        System.out.println("Denominations: " + Arrays.toString(denominations1));
        System.out.println("Amount: " + amount1);
        calculateMinimumNotes(denominations1, amount1);
        
        // Test Case 2: From problem statement
        System.out.println("\nTest Case 2:");
        int[] denominations2 = {60, 5, 12, 78, 25};
        int amount2 = 128;
        System.out.println("Denominations: " + Arrays.toString(denominations2));
        System.out.println("Amount: " + amount2);
        calculateMinimumNotes(denominations2, amount2);
        
        // Test Case 3: From problem statement
        System.out.println("\nTest Case 3:");
        int[] denominations3 = {12, 5, 123, 18};
        int amount3 = 158;
        System.out.println("Denominations: " + Arrays.toString(denominations3));
        System.out.println("Amount: " + amount3);
        calculateMinimumNotes(denominations3, amount3);
        
        // Additional Test Cases
        System.out.println("\nAdditional Test Case 4 - Standard Currency:");
        int[] denominations4 = {1, 5, 10, 20, 50, 100, 500};
        int amount4 = 1247;
        System.out.println("Denominations: " + Arrays.toString(denominations4));
        System.out.println("Amount: " + amount4);
        calculateMinimumNotes(denominations4, amount4);
        
        System.out.println("\nAdditional Test Case 5 - Exact Match:");
        int[] denominations5 = {10, 20, 50};
        int amount5 = 50;
        System.out.println("Denominations: " + Arrays.toString(denominations5));
        System.out.println("Amount: " + amount5);
        calculateMinimumNotes(denominations5, amount5);
        
        System.out.println("\nAdditional Test Case 6 - Edge Case:");
        int[] denominations6 = {7, 3};
        int amount6 = 1;
        System.out.println("Denominations: " + Arrays.toString(denominations6));
        System.out.println("Amount: " + amount6);
        calculateMinimumNotes(denominations6, amount6);
    }
    
    /**
     * Enhanced version with input validation
     */
    public static void solveWithValidation() {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.println("enter the size of currency denominations");
            int size = scanner.nextInt();
            
            if (size <= 0) {
                System.out.println("Error: Size must be positive!");
                return;
            }
            
            int[] denominations = new int[size];
            System.out.println("enter the currency denominations value");
            for (int i = 0; i < size; i++) {
                denominations[i] = scanner.nextInt();
                if (denominations[i] <= 0) {
                    System.out.println("Error: All denominations must be positive!");
                    return;
                }
            }
            
            System.out.println("enter the amount you want to pay");
            int amount = scanner.nextInt();
            
            if (amount <= 0) {
                System.out.println("Error: Amount must be positive!");
                return;
            }
            
            calculateMinimumNotes(denominations, amount);
            
        } catch (Exception e) {
            System.out.println("Error: Invalid input format!");
        } finally {
            scanner.close();
        }
    }
    
    /**
     * Method to calculate total number of notes used
     */
    public static int getTotalNotesCount(int[] denominations, int amount) {
        Integer[] sortedDenominations = new Integer[denominations.length];
        for (int i = 0; i < denominations.length; i++) {
            sortedDenominations[i] = denominations[i];
        }
        Arrays.sort(sortedDenominations, Collections.reverseOrder());
        
        int remainingAmount = amount;
        int totalNotes = 0;
        
        for (int denomination : sortedDenominations) {
            if (remainingAmount >= denomination) {
                int notesNeeded = remainingAmount / denomination;
                totalNotes += notesNeeded;
                remainingAmount = remainingAmount % denomination;
            }
        }
        
        return remainingAmount == 0 ? totalNotes : -1; // -1 if exact payment not possible
    }
    
    /**
     * Method to check if exact payment is possible
     */
    public static boolean isExactPaymentPossible(int[] denominations, int amount) {
        return getTotalNotesCount(denominations, amount) != -1;
    }
    
    /**
     * Performance analysis method
     */
    public static void performanceAnalysis() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("CURRENCY ALGORITHM ANALYSIS");
        System.out.println("=".repeat(60));
        
        System.out.println("Algorithm: Greedy Approach");
        System.out.println("Time Complexity: O(n log n) for sorting + O(n) for processing = O(n log n)");
        System.out.println("Space Complexity: O(n) for sorted denomination array");
        System.out.println("Optimality: Greedy gives optimal solution for this problem");
        System.out.println("Strategy: Always use largest possible denomination first");
        
        // Demonstration with example
        System.out.println("\nExample Walkthrough:");
        int[] demo = {5, 1, 10};
        int demoAmount = 12;
        System.out.println("Denominations: " + Arrays.toString(demo));
        System.out.println("Amount: " + demoAmount);
        System.out.println("Sorted (descending): [10, 5, 1]");
        System.out.println("Step 1: 12 ÷ 10 = 1 note, remainder = 2");
        System.out.println("Step 2: 2 ÷ 5 = 0 notes, remainder = 2");
        System.out.println("Step 3: 2 ÷ 1 = 2 notes, remainder = 0");
        System.out.println("Result: 10:1, 1:2 (Total: 3 notes)");
    }
}
