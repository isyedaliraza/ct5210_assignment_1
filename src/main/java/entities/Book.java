package entities;

import java.util.UUID;

public class Book {
    private String id;
    private String isbn;
    private String title;
    private String author;

    public Book(String isbn, String title, String author) {
        this.id = UUID.randomUUID().toString();
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getId() {
        return id;
    }
}
