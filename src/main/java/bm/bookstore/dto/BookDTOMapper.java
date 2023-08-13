package bm.bookstore.dto;

import bm.bookstore.entities.BookEntity;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class BookDTOMapper implements Function<BookEntity, BookDTO> {
    @Override
    public BookDTO apply(BookEntity bookEntity) {
        return BookDTO.from(bookEntity);
    }
}
