public class DealCards {
    public static void main(String[] args) {
        System.out.println("fivee random pick ");

        for (int i = 0; i < 5;i++) {
            Card card = Card.getRandomCard();
            System.out.println("Card" + (i+1) + ":" + card);
        }
    }
}
