package bm.bookstore;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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
        return this.books.stream().filter(b -> title.equals(b.title())).findAny().orElse(null);
    }
    public BookEntity findBookByAuthor(String author) {
        return this.books.stream().filter(b -> author.equals(b.author())).findAny().orElse(null);
    }

    public BookEntity getBookDetailsByID(int id) {
        return this.books.stream().filter(b -> id == b.id()).findAny().orElse(null);
    }
}
