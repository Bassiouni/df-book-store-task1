package bm.bookstore.repository;

import bm.bookstore.entities.BookEntity;
import bm.bookstore.exceptions.BookNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class BookRepo {
    private final ArrayList<BookEntity> books;

    public BookRepo(ArrayList<BookEntity> books) {
        this.books = books;
    }

    public void addBook(BookEntity bookEntity) {
        this.books.add(bookEntity);
    }

    public List<BookEntity> getAllBooks() {
        return this.books;
    }

    public BookEntity findBookByTitle(String title) {
        return this.books.stream().filter(b -> title.equals(b.getTitle())).findAny().orElseThrow(() -> new BookNotFoundException("Book not found"));
    }
    public BookEntity findBookByAuthor(String author) throws NoSuchElementException {
        return this.books.stream().filter(b -> author.equals(b.getAuthor())).findAny().orElseThrow();
    }

    public BookEntity getBookDetailsByID(int id) throws NoSuchElementException {
        return this.books.stream().filter(b -> id == b.getId()).findAny().orElseThrow();
    }

    public void updateBookByID(BookEntity bookEntity) {
        this.books.forEach(b -> {
            if (bookEntity.getId() == b.getId()) {
                b.replaceWith(bookEntity);
            }
        });
    }

    public boolean removeBookByID(int id) {
        return this.books.removeIf(bookEntity -> bookEntity.getId() == id);
    }
}
