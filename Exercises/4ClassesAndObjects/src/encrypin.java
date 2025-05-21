import java.util.Random;
import java.util.Scanner;

public class encrypin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        // Get pi from the user
        System.out.print("Enter a 4-digit pin number to encrypt: ");
        String pinHex = Integer.toHexString(sc.nextInt()); // Convert PIN to Hex

        // Generate n convert to  hex
        String randomHex1 = Integer.toHexString(rand.nextInt(64536) + 1000);
        String randomHex2 = Integer.toHexString(rand.nextInt(64536) + 1000);

        // Concatenate the hex values
        String encryptedPin = randomHex1 + pinHex + randomHex2;

        // Output
        System.out.println("Your encrypted pin number is: " + encryptedPin);

    }
}
