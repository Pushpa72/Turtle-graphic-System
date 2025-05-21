import java.util.Scanner;
public class Histogram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] bins = new int[10]; // 10 ranges (1–10, 11–20, ..., 91–100)
        System.out.println("Enter integers between 1 and 100 (type -1 to stop):");
        while (true) {
            int num = scanner.nextInt();
            if (num == -1) break;
            if (num >= 1 && num <= 100) {
                int index = (num - 1) / 10;
                bins[index]++;
            } else {
                System.out.println("enter between 1 to 100");
            }
        }
        System.out.println("Histogram:");
        for (int i = 0; i < bins.length; i++) {
            int rangeStart = i * 10 + 1;
            int rangeEnd = (i + 1) * 10;
            System.out.printf("%-3d - %-3d : ", rangeStart, rangeEnd);
            for (int j = 0; j < bins[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        scanner.close();
    }
}
