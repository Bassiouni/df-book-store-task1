package bm.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Task1Application {
//    private final BookService bookService;
//    private Scanner scanner;
//
//    public Task1Application(BookService bookService) {
//        this.bookService = bookService;
//    }


    public static void main(String[] args) {
        SpringApplication.run(Task1Application.class, args);
    }

//    @Override
//    public void run(String... args) {
//        System.out.println("Welcome to the Book Library");
//        scanner = new Scanner(System.in);
//        while (true) {
//            System.out.print("""
//                Choose from the following:
//                1. view all books
//                2. search book
//                3. add new book
//                4. exit
//                >>""");
//            int choice = scanner.nextInt();
//            if (choice == 4)
//                break;
//
//            switch (choice) {
//                case 1 -> {
//                    iterateOverAllBooks();
//                }
//                case 2 -> {
//                    searchBooks();
//                }
//                case 3 -> {
//                    addNewBook();
//                }
//            }
//
//            scanner.close();
//        }
//    }
//
//    private void addNewBook() {
//        System.out.print("id: ");
//        int id = scanner.nextInt();
//
//        System.out.print("title: ");
//        String title = scanner.next();
//
//        System.out.print("author: ");
//        String author = scanner.next();
//
//        System.out.print("description: ");
//        String description = scanner.next();
//
//        System.out.print("price: ");
//        double price = scanner.nextDouble();
//
//        System.out.print("quantity: ");
//        int quantity = scanner.nextInt();
//
//        this.bookService.addBook(new BookEntity(id, title, author, description, price, quantity));
//    }
//
//    private void searchBooks() {
//        System.out.print("""
//                1. by title
//                2. bt id
//                3. by author
//                >>""");
//        int input = scanner.nextInt();
//        if (input == 1) {
//            System.out.print("Title: ");
//            String title = scanner.next();
//            BookEntity b = this.bookService.searchBooksByTitle(title);
//            printBookEntity(b);
//        } else if (input == 2) {
//            System.out.print("id: ");
//            int id = scanner.nextInt();
//            BookEntity b = this.bookService.getBookByID(id);
//            printBookEntity(b);
//        } else if (input == 3) {
//            String author = scanner.next();
//            BookEntity b = this.bookService.searchBookByAuthor(author);
//            printBookEntity(b);
//        } else {
//            System.out.println("Abort\nBad input");
//            System.exit(1);
//        }
//    }
//
//    private static void printBookEntity(BookEntity b) {
//        if (b != null)
//            System.out.println(b);
//        else
//            System.out.println("Not Found");
//    }
//
//    private void iterateOverAllBooks() {
//        for (BookEntity b : this.bookService.getAllBooks()) {
//            System.out.println(b.toString());
//        }
//    }
}
