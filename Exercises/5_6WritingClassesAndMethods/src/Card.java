import java.util.Random;

public class Card {
    private String suit;
    private String faceValue;
    private static final String[] SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};
    private static final String[] FACE_VALUES = {
            "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "Jack", "Queen", "King", "Ace"
    };

    public Card(String suit, String faceValue) { // Constructor
        this.suit = suit;
        this.faceValue = faceValue;
    }

    public String getSuit() {
        return suit;
    }

    public String getFaceValue() {
        return faceValue;
    }
    public void setSuit(String suit) {
        this.suit = suit;
    }

    public void setFaceValue(String faceValue) {
        this.faceValue = faceValue;
    }
    public String toString() {
        return faceValue + " of " + suit;
    }
    public static Card getRandomCard() {
        Random rand = new Random();
        String randomSuit = SUITS[rand.nextInt(SUITS.length)];
        String randomFaceValue = FACE_VALUES[rand.nextInt(FACE_VALUES.length)];
        return new Card(randomSuit, randomFaceValue);
    }
}
