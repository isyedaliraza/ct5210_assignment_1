package adapters;

import entities.Book;
import entities.Member;

import java.util.ArrayList;

public interface LibraryRepository {
    public void addBook(Book book);
    public void registerMember(Member member);
    public void borrowBook(String bookId, String memberId);
    public void returnBook(String id);
    public ArrayList<Book> listBooks();
}
