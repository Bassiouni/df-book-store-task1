package bm.bookstore.controller;

import bm.bookstore.dto.BookDTO;
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
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<BookDTO> bookEntities = this.bookService.getAllBooks();
        return ResponseEntity.status(HttpStatus.OK).body(bookEntities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookByID(@PathVariable int id) {
        try {
            BookDTO bookEntity = this.bookService.getBookByID(id);
            return ResponseEntity.status(HttpStatus.OK).body(bookEntity);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/")
    public ResponseEntity<BookDTO> addBook(@RequestBody BookDTO bookEntity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.bookService.addOrUpdateBook(bookEntity));
    }

    @PutMapping("/")
    public ResponseEntity<BookDTO> updateBookByID(@RequestBody BookDTO bookEntity) {
        return ResponseEntity.status(HttpStatus.OK).body(this.bookService.addOrUpdateBook(bookEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBookByID(@PathVariable int id) {

        if (this.bookService.bookExistsById(id)) {
            this.bookService.removeBookByID(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The provided ID is not found");
    }
}
