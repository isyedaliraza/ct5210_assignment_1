package usecases;

import adapters.LibraryRepository;
import entities.Book;

public class SearchBookUsecase {
    private final LibraryRepository repository;

    public SearchBookUsecase(LibraryRepository repository) {
        this.repository = repository;
    }

    public Book searchBook(String title) {
        return repository.searchBook(title);
    }
}
