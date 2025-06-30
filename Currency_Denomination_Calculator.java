import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class CurrencyDenominationApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter the size of currency denominations");
        int size = sc.nextInt();
        Integer[] denominations = new Integer[size];

        System.out.println("enter the currency denominations value");
        for (int i = 0; i < size; i++) {
            denominations[i] = sc.nextInt();
        }

        Arrays.sort(denominations, Collections.reverseOrder());

        System.out.println("enter the amount you want to pay");
        int amount = sc.nextInt();

        int[] noteCount = new int[size];
        int originalAmount = amount;

        for (int i = 0; i < size; i++) {
            if (denominations[i] <= amount) {
                noteCount[i] = amount / denominations[i];
                amount = amount % denominations[i];
            }
        }

        if (amount != 0) {
            System.out.println("Exact amount cannot be paid with the given denominations.");
        } else {
            System.out.println("Your payment approach in order to give min no of notes will be");
            for (int i = 0; i < size; i++) {
                if (noteCount[i] != 0) {
                    System.out.println(denominations[i] + ":" + noteCount[i]);
                }
            }
        }
    }
}
