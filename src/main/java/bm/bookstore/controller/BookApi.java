package bm.bookstore.controller;

import bm.bookstore.entities.BookEntity;
import bm.bookstore.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/book")
public class BookApi {
    private final BookService bookService;

    public BookApi(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public ResponseEntity<List<BookEntity>> getAllBooks() {
        List<BookEntity> bookEntities = this.bookService.getAllBooks();
        return ResponseEntity.status(HttpStatus.OK).body(bookEntities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookEntity> getBookByID(@PathVariable String id) {
        try {
            BookEntity bookEntity = this.bookService.getBookByID(Integer.parseInt(id));
            return ResponseEntity.status(HttpStatus.OK).body(bookEntity);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/")
    public ResponseEntity<BookEntity> addBook(@RequestBody BookEntity bookEntity) {
        this.bookService.addBook(bookEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookEntity);
    }

    @PutMapping("/")
    public ResponseEntity<BookEntity> updateBookByID(@RequestBody BookEntity bookEntity) {
        this.bookService.updateBookByID(bookEntity);
        return ResponseEntity.status(HttpStatus.OK).body(bookEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBookByID(@PathVariable String id) {
        int bid = Integer.parseInt(id);

        if (this.bookService.removeBookByID(bid)) {
            return ResponseEntity.status(HttpStatus.OK).build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The provided ID is not found");
    }
}
