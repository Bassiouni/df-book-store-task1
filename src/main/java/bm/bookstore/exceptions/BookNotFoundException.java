package bm.bookstore.exceptions;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such book")
@Log4j2
public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message) {
        super(message);
        log.error("Throwing BookNotFoundException: " + message);
    }
}


