public class BookShelf {
    public static void main(String[] args) {
        Book book1 = new Book("No Longer Woman", "Osamu Dazai", "Chikuma Shobō", 1948);
        Book book2 = new Book("Totto-Chan: The Little Girl at the Window", "Tetsuko Kuroyanagi", "Kodansha Publishers Ltd.", 1981);

        System.out.println(book1.toString());
        System.out.println();
        System.out.println(book2.toString());

        book1.setTitle("No longer HUman");
        book1.setCopyrightDate(2015);

        System.out.println("\nUpdated Book 1:");
        System.out.println(book1.toString());
    }
}