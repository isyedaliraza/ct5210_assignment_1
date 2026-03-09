package usecases;

import adapters.LibraryRepository;

public class ReturnBookUseCase {
    private final LibraryRepository repository;

    public ReturnBookUseCase(LibraryRepository repository) {
        this.repository = repository;
    }

    public void returnBook(String bookId) {
        this.repository.returnBook(bookId);
    }
}
