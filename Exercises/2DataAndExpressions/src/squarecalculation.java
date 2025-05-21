import java.util.Scanner;

public class squarecalculation {
    public static void main(String[] args) {
        int length,perimeter,area;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length of Square: ");
        length = sc.nextInt();
        perimeter=4*length ;
        area = length* length ;
        System.out.println("The perimeter of the square is: " + perimeter);
        System.out.println("The area of the square is: " + area);
        sc.close();
    }
}

