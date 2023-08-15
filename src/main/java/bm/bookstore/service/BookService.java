package bm.bookstore.service;

import bm.bookstore.dto.BookDTO;
import bm.bookstore.dto.BookDTOMapper;
import bm.bookstore.entities.BookEntity;
import bm.bookstore.exceptions.BookNotFoundException;
import bm.bookstore.repository.IBookRepoJPA;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final IBookRepoJPA bookRepo;
    private final BookDTOMapper bookDTOMapper;

    public BookService(IBookRepoJPA bookRepo, BookDTOMapper bookDTOMapper) {
        this.bookRepo = bookRepo;
        this.bookDTOMapper = bookDTOMapper;
    }

    public List<BookDTO> getAllBooks() {
        List<BookEntity> bookEntities = (List<BookEntity>) this.bookRepo.findAll();
        return bookEntities.stream().map(bookDTOMapper).collect(Collectors.toList());
    }

    public BookDTO getBookByID(Integer id) throws BookNotFoundException {
        Optional<BookEntity> book = this.bookRepo.findById(id);
        if (book.isEmpty())
            throw new BookNotFoundException("Book not found");
        return BookDTO.from(book.get());
    }

    public BookDTO addOrUpdateBook(BookDTO bookDTO) {
        return BookDTO.from(this.bookRepo.save(BookEntity.from(bookDTO)));
    }

    public void removeBookByID(int id) {
        this.bookRepo.deleteById(id);
    }

    public boolean bookExistsById(Integer id) {
        return this.bookRepo.existsById(id);
    }
}
