package bookpack;

public class Book {
    protected String title;
    protected String author;
    protected int pubDate;

    public Book(String title, String author, int pubDate) {
        this.title = title;
        this.author = author;
        this.pubDate = pubDate;
    }

    public void show() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Pub Date: " + pubDate);
    }
}