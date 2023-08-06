package bm.bookstore;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }
    public List<BookEntity> getAllBooks() {
        return this.bookRepo.getAllBooks();
    }

    public BookEntity searchBooksByTitle(String title) {
        return this.bookRepo.findBookByTitle(title);
    }

    public BookEntity searchBookByAuthor(String author) {
        return this.bookRepo.findBookByAuthor(author);
    }

    public BookEntity getBookByID(int id) {
        return this.bookRepo.getBookDetailsByID(id);
    }

    public void addBook(BookEntity b) {
        this.bookRepo.addBook(b);
    }
}
