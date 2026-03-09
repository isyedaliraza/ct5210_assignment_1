package adapters;

import entities.Book;
import entities.Member;
import usecases.*;

import java.util.ArrayList;

public class LibraryController {

    private final AddBookUseCase addBookUseCase;

    private final RegisterMemberUseCase registerMemberUseCase;

    private final BorrowBookUseCase borrowBookUseCase;

    private final ReturnBookUseCase returnBookUseCase;

    private final ListBooksUseCase listBooksUseCase;

    private final ListMembersUseCase listMembersUseCase;

    private final SearchBookUsecase searchBookUsecase;

    public LibraryController(
            AddBookUseCase addBookUseCase, RegisterMemberUseCase registerMemberUseCase,
            BorrowBookUseCase borrowBookUseCase, ReturnBookUseCase returnBookUseCase,
            ListBooksUseCase listBooksUseCase, ListMembersUseCase listMembersUseCase,
            SearchBookUsecase searchBookUsecase
    ) {
        this.addBookUseCase = addBookUseCase;
        this.registerMemberUseCase = registerMemberUseCase;
        this.borrowBookUseCase = borrowBookUseCase;
        this.returnBookUseCase = returnBookUseCase;
        this.listBooksUseCase = listBooksUseCase;
        this.listMembersUseCase = listMembersUseCase;
        this.searchBookUsecase = searchBookUsecase;
    }


    public void addBook(String isbn, String title, String author) {
        Book book = new Book(isbn, title, author);
        addBookUseCase.addBook(book);
    }

    public void registerMember(String firstName, String lastName, String email) {
        Member member = new Member(firstName, lastName, email);
        registerMemberUseCase.registerMember(member);
    }

    public void borrowBook(String bookId, String memberId) {
        borrowBookUseCase.borrowBook(bookId, memberId);
    }

    public void returnBook(String bookId) {
        returnBookUseCase.returnBook(bookId);
    }

    public ArrayList<Book> getAvailableBooks() {
        return listBooksUseCase.listBooks();
    }

    public ArrayList<Member> getMembers() {
        return listMembersUseCase.listMembers();
    }

    public Book searchBook(String title) {
        return searchBookUsecase.searchBook(title);
    }
}
