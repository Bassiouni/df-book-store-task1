package bm.bookstore.service;

import bm.bookstore.entities.BookEntity;
import bm.bookstore.repository.BookRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookService {
    private final BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }
    public List<BookEntity> getAllBooks() {
        return this.bookRepo.getAllBooks();
    }

    public BookEntity searchBooksByTitle(String title) throws NoSuchElementException {
        return this.bookRepo.findBookByTitle(title);
    }

    public BookEntity searchBookByAuthor(String author) throws NoSuchElementException {
        return this.bookRepo.findBookByAuthor(author);
    }

    public BookEntity getBookByID(int id) throws NoSuchElementException {
        return this.bookRepo.getBookDetailsByID(id);
    }

    public void addBook(BookEntity b) {
        this.bookRepo.addBook(b);
    }

    public void updateBookByID(BookEntity id) {
        this.bookRepo.updateBookByID(id);
    }

    public boolean removeBookByID(int id) {
        return this.bookRepo.removeBookByID(id);
    }
}
