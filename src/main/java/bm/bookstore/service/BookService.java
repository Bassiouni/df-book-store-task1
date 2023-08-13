package bm.bookstore.service;

import bm.bookstore.dto.BookDTO;
import bm.bookstore.dto.BookDTOMapper;
import bm.bookstore.entities.BookEntity;
import bm.bookstore.repository.IBookRepoJPA;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
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

    // public BookDTO searchBooksByTitle(String title) throws NoSuchElementException {
    //     return BookDTO.from(this.bookRepo.findBookByTitle(title));
    // }

    // public BookDTO searchBookByAuthor(String author) throws NoSuchElementException {
    //     return BookDTO.from(this.bookRepo.findBookByAuthor(author));
    // }

    public BookDTO getBookByID(Integer id) throws NoSuchElementException {
        return BookDTO.from(this.bookRepo.findById(id).get());
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
