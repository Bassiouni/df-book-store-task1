package bm.bookstore.controller;

import bm.bookstore.dto.BookDTO;
import bm.bookstore.service.BookService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/book")
@Log4j2
public class BookApi {
    private final BookService bookService;

    public BookApi(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<BookDTO> bookEntities = this.bookService.getAllBooks();
        log.info("[BookApiController]: retrieving all books");
        return ResponseEntity.status(HttpStatus.OK).body(bookEntities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookByID(@PathVariable int id) {
        log.info("[BookApiController]: Getting book with id=" + id);
        try {
            BookDTO bookEntity = this.bookService.getBookByID(id);
            return ResponseEntity.status(HttpStatus.OK).body(bookEntity);
        } catch (NoSuchElementException e) {
            log.error("[BookApiController]: Returning 404");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/")
    public ResponseEntity<BookDTO> addBook(@Valid @RequestBody BookDTO bookDTO) {
        log.info("[BookApiController]: Adding Book:" + bookDTO.id());
        return ResponseEntity.status(HttpStatus.CREATED).body(this.bookService.addOrUpdateBook(bookDTO));
    }

    @PutMapping("/")
    public ResponseEntity<BookDTO> updateBookByID(@Valid @RequestBody BookDTO bookDTO) {
        log.info("[BookApiController]: Updating Book:" + bookDTO.id());
        return ResponseEntity.status(HttpStatus.OK).body(this.bookService.addOrUpdateBook(bookDTO));
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
