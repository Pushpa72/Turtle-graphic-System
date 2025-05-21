import java.util.Scanner;

public class StringReverser {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //  input
        System.out.print("Enter a sentence: ");
        String sentence = scan.nextLine();
        String[] words = sentence.split(" ");
        StringBuilder reversedSentence = new StringBuilder();

        // Reverse
        for (String word : words) {
            StringBuilder reversedWord = new StringBuilder(word);
            reversedSentence.append(reversedWord.reverse()).append(" ");
        }

        //  result
        System.out.println("Reversed sentence: " + reversedSentence.toString().trim());

        scan.close();
    }
}
