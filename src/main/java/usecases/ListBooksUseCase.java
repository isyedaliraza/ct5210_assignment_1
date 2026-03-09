package usecases;

import adapters.LibraryRepository;
import entities.Book;

import java.util.ArrayList;

public class ListBooksUseCase {
    private final LibraryRepository repository;

    public ListBooksUseCase(LibraryRepository repository) {
        this.repository = repository;
    }

    public ArrayList<Book> listBooks() {
        return this.repository.listAvailableBooks();
    }
}
