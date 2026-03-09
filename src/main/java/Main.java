import adapters.LibraryController;
import adapters.LibraryRepository;
import frameworks.ConsoleApp;
import frameworks.InMemoryLibraryRepository;
import usecases.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Setup Dependencies
        Scanner in = new Scanner(System.in);
        LibraryRepository repository = new InMemoryLibraryRepository();
        LibraryController controller = createLibraryController(repository);
        ConsoleApp app = new ConsoleApp(in, controller);

        // Start the app
        app.start();

        // Clean up resources
        in.close();
    }

    public static LibraryController createLibraryController(LibraryRepository repository) {
        AddBookUseCase addBookUseCase = new AddBookUseCase(repository);
        RegisterMemberUseCase registerMemberUseCase = new RegisterMemberUseCase(repository);
        BorrowBookUseCase borrowBookUseCase = new BorrowBookUseCase(repository);
        ReturnBookUseCase returnBookUseCase = new ReturnBookUseCase(repository);
        ListBooksUseCase listBooksUseCase = new ListBooksUseCase(repository);
        ListMembersUseCase listMembersUseCase = new ListMembersUseCase(repository);
        SearchBookUsecase searchBookUsecase = new SearchBookUsecase(repository);

        return new LibraryController(addBookUseCase, registerMemberUseCase,
                borrowBookUseCase, returnBookUseCase, listBooksUseCase, listMembersUseCase, searchBookUsecase);
    }
}
