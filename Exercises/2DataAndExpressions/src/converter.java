import java.util.Scanner;

public class converter {
    public static void main(String[] args) {
        float miles,kilometers;
        final float METERS_PER_MILE = 1.609344f;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the distance in miles: ");
        miles = sc.nextFloat();
        kilometers = miles * METERS_PER_MILE ;
        System.out.println(miles + " is equal to " +kilometers);
        sc.close();


    }
}
