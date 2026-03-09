package frameworks;

import adapters.LibraryRepository;
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

        for (Book book : books) {
            if (book.getId().equals(bookId)) {
                book.setAvailable(false);
                break;
            }
        }
    }

    @Override
    public void returnBook(String bookId) {
        borrowRecords.removeIf(record -> record.getBookId().equals(bookId));

        for (Book book : books) {
            if (book.getId().equals(bookId)) {
                book.setAvailable(true);
                break;
            }
        }
    }

    @Override
    public ArrayList<Book> listAvailableBooks() {
        ArrayList<Book> availableBooks = new ArrayList<>();

        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }

        return availableBooks;
    }

    @Override
    public ArrayList<Member> listMembers() {
        return members;
    }

    @Override
    public Book searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }

        return null;
    }
}
