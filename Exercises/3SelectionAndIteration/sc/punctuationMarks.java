public class punctuationMarks {
    public static void main(String[] args) {
        // from qns
        String text = "Mary had a little lamb, her fleece was as white as snow, and everywhere Mary went, the lamb was sure to go.\n-that was a nice poem-\nthe end.";

        // Array of punctuation marks to track
        char[] punctuationMarks = {',', '.', '-', '\n'};
        int[] count = new int[punctuationMarks.length]; // Array to store counts

        // Count occurrences of each punctuation mark
        for (char ch : text.toCharArray()) {
            for (int i = 0; i < punctuationMarks.length; i++) {
                if (ch == punctuationMarks[i]) {
                    count[i]++;
                }
            }
        }

        // Display the table
        System.out.println("Punctuation Mark | Count");
        System.out.println("-----------------|------");
        for (int i = 0; i < punctuationMarks.length; i++) {
            System.out.printf("        %c        |   %d%n", punctuationMarks[i], count[i]);
        }
    }
}
