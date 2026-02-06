package adapters;

import entities.Book;
import entities.BorrowRecord;
import entities.Member;

import java.time.LocalDate;
import java.util.ArrayList;

public class InMemoryLibraryRepository implements LibraryRepository {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<BorrowRecord> borrowRecords = new ArrayList<>();

    @Override
    public void addBook(Book book) {
        this.books.add(book);
    }

    @Override
    public void registerMember(Member member) {
        this.members.add(member);
    }

    @Override
    public void borrowBook(String bookId, String memberId) {
        String dueDate = LocalDate.now().plusMonths(1).toString();
        BorrowRecord record = new BorrowRecord(bookId, memberId, dueDate);
        borrowRecords.add(record);
    }

    @Override
    public void returnBook(String id) {
    }

    @Override
    public ArrayList<Book> listBooks() {
        return null;
    }
}
