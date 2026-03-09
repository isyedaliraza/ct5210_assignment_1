package frameworks;

import adapters.LibraryController;
import entities.Book;
import entities.Member;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleApp {
    private final Scanner in;
    private final LibraryController controller;

    public ConsoleApp(Scanner in, LibraryController controller) {
        this.in = in;
        this.controller = controller;
    }

    public void start() {
        int option;

        do {
            displayMenu();
            option = getUserInput();
            switch (option) {
                case 1:
                    addBook();
                    break;
                case 2:
                    registerMember();
                    break;
                case 3:
                    borrowBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    listBooks();
                    break;
                case 6:
                    searchBook();
                    break;
                default:
                    System.out.println("Please select a valid option.");
            }
        } while (option != 0);

        System.out.println("Exiting the app. Good bye.");
    }

    private void displayMenu() {
        System.out.println("======================================");
        System.out.println("     LIBRARY BOOK BORROWING SYSTEM    ");
        System.out.println("======================================");
        System.out.println("1. Add a new book");
        System.out.println("2. Register a library member");
        System.out.println("3. Borrow a book");
        System.out.println("4. Return a book");
        System.out.println("5. View all available books");
        System.out.println("6. Search book");
        System.out.println("0. Exit");
        System.out.println("======================================");
        System.out.print("Please select an option: ");
    }

    private void searchBook() {
        if (in.hasNextLine()) {
            in.nextLine();
        }

        System.out.print("Enter the title of the book: ");
        String title = in.nextLine();
        Book book = controller.searchBook(title);
        if (book == null) {
            System.out.printf("No book found with title \"%s\"\n", title);
        } else {
            System.out.printf("%36s %13s %20s %20s %10s\n", "Id", "ISBN", "Title", "Author", "Is Available?");
            System.out.println("=".repeat(125));
            System.out.printf("%36s %13s %20s %20s %10s\n", book.getId(), book.getIsbn(), book.getTitle(),
                    book.getAuthor(),
                    book.isAvailable() ? "Yes" : "No");
        }
    }

    private int getUserInput() {
        while (!in.hasNextInt()) {
            System.out.println("Invalid input");
            in.next();
            System.out.print("Please select an option: ");
        }
        return in.nextInt();
    }

    private void addBook() {
        if (in.hasNextLine()) {
            in.nextLine();
        }

        System.out.print("Book ISBN: ");
        String isbn = in.nextLine();

        System.out.print("Book Title: ");
        String title = in.nextLine();

        System.out.print("Book Author: ");
        String author = in.nextLine();

        controller.addBook(isbn, title, author);
    }

    private void registerMember() {
        if (in.hasNextLine()) {
            in.nextLine();
        }

        System.out.print("First Name: ");
        String firstName = in.nextLine();

        System.out.print("Last Name: ");
        String lastName = in.nextLine();

        System.out.print("Email: ");
        String email = in.nextLine();

        controller.registerMember(firstName, lastName, email);
    }

    private void borrowBook() {
        int option;
        ArrayList<Book> books = controller.getAvailableBooks();
        ArrayList<Member> members = controller.getMembers();

        System.out.println("Available Books");
        System.out.println("===============");
        for (int i = 0; i < books.size(); i++) {
            System.out.printf("%d) %s\n", i + 1, books.get(i).getTitle());
        }

        System.out.print("Select book: ");

        option = in.nextInt();
        Book selectedBook = books.get(option - 1);

        System.out.println("Registered Members");
        System.out.println("==================");
        for (int i = 0; i < members.size(); i++) {
            System.out.printf("%d) %s %s\n", i + 1, members.get(i).getFirstName(), members.get(i).getLastName());
        }

        System.out.print("Select member: ");

        option = in.nextInt();
        Member selectedMember = members.get(option - 1);

        controller.borrowBook(selectedBook.getId(), selectedMember.getId());
    }

    private void returnBook() {
        if (in.hasNextLine()) {
            in.nextLine();
        }

        System.out.print("Enter book ID: ");
        String bookId = in.nextLine();
        controller.returnBook(bookId);
    }

    private void listBooks() {
        ArrayList<Book> books = controller.getAvailableBooks();
        System.out.printf("%36s %13s %20s %20s %10s\n", "Id", "ISBN", "Title", "Author", "Is Available?");
        System.out.println("=".repeat(125));
        for (Book book : books) {
            System.out.printf("%36s %13s %20s %20s %10s\n", book.getId(), book.getIsbn(), book.getTitle(),
                    book.getAuthor(), book.isAvailable() ? "Yes" : "No");
        }
        System.out.println("=".repeat(125));
    }
}
