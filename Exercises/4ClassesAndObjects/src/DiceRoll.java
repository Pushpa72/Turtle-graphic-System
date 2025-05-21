import java.util.Scanner;
import java.util.Random;

public class DiceRoll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        // Prompt user for the number of sides for each dice
        System.out.print("How many sides does dice 1 have? ");
        int sidesDie1 = scanner.nextInt();

        System.out.print("How many sides does dice 2 have? ");
        int sidesDice2 = scanner.nextInt();

        int sumDice1 = 0, sumDice2 = 0;

        // Roll the dice three times
        for (int i = 1; i <= 3; i++) {
            int rollDice1 = rand.nextInt(sidesDie1) + 1; // Generate number between 1 and sidesDice1
            int rollDice2 = rand.nextInt(sidesDice2) + 1; // Generate number between 1 and sidesDice2

            sumDice1 += rollDice1;
            sumDice2 += rollDice2;

            System.out.println("Die 1 roll " + i + " = " + rollDice1 + ".");
            System.out.println("Die 2 roll " + i + " = " + rollDice2 + ".");
        }

        // Calculate and display total and average
        double avgDice1 = sumDice1 / 3.0;
        double avgDice2 = sumDice2 / 3.0;

        System.out.println("Die 1 rolled a total of " + sumDice1 + " and rolled " + avgDice1 + " on average.");
        System.out.println("Die 2 rolled a total of " + sumDice2 + " and rolled " + avgDice2 + " on average.");

        scanner.close();
    }
}
