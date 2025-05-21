
import java.util.Scanner;
public class ComputingAverages {

// *******************************************************************
//   Average.java
//
//   Read three integers from the user and print their average
// *******************************************************************
    public static void main(String[] args) {
        int val1, val2, val3;
        double average;
        Scanner scan = new Scanner(System.in) ;


        // get three values from user
        System.out.println("Please enter three integers and " +
                "I will compute their average");

        System.out.print("Enter three integers: ");
        val1=scan.nextInt();
        val2=scan.nextInt();
        val3=scan.nextInt();

        //compute the average
        average=(val1+val2+val3)/3.0;

        //print the average
        System.out.println("The average is "+average);

        scan.close();


    }
}
