package usecases;

import adapters.LibraryRepository;

public class BorrowBookUseCase {
    private final LibraryRepository repository;

    public BorrowBookUseCase(LibraryRepository repository) {
        this.repository = repository;
    }

    public void borrowBook(String bookId, String memberId) {
        this.repository.borrowBook(bookId, memberId);
    }
}
