package usecases;

import adapters.LibraryRepository;
import entities.Book;

public class AddBookUseCase {
    private final LibraryRepository repository;

    public AddBookUseCase(LibraryRepository repository) {
        this.repository = repository;
    }

    public void addBook(Book book) {
        this.repository.addBook(book);
    }
}
