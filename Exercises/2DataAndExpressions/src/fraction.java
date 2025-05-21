import java.util.Scanner;

public class fraction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the numerator ");
        int num = sc.nextInt();
        System.out.print("Enter the denominator ");
        int den = sc.nextInt();
        double fraction = (double)num / den;
        System.out.println("    Decimal equivalent : " + fraction);
      sc.close();
    }
}
