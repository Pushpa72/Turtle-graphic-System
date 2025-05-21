public class Book {
    private String title;
    private String author;
    private String publisher;
    private int copyrightDate;

    public Book(String title, String author, String publisher, int copyrightDate) {  // Constructor
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.copyrightDate = copyrightDate;
    }

    // Getter and setter for title
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getCopyrightDate() {
        return copyrightDate;
    }
    public void setCopyrightDate(int copyrightDate) {
        this.copyrightDate = copyrightDate;
    }

    @Override
    public String toString() {
        return "Book Details:\n" +
                "Title: " + title + "\n" +
                "Author: " + author + "\n" +
                "Publisher: " + publisher + "\n" +
                "Copyright Date: " + copyrightDate;
    }
}
