import java.util.Scanner;

public class spherecal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the radius of the sphere: ");
        double radius = sc.nextDouble();

        double volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);

        double surfaceArea = 4 * Math.PI * Math.pow(radius, 2);

        //  rounded to four decimal places
        System.out.printf("Volume: %.4f%n", volume);
        System.out.printf("Surface Area: %.4f%n", surfaceArea);
    }
}
