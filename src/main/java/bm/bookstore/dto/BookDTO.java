package bm.bookstore.dto;

import bm.bookstore.entities.BookEntity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record BookDTO(
        @NotNull(message = "Please specify the ID")
        int id,

        @NotNull(message = "Title shouldn't be empty")
        @Min(1)
        @Max(50)
        String title,

        @NotNull(message = "Author name shouldn't be empty")
        @Max(50)
        String author,

        @NotNull(message = "Description shouldn't be empty")
        @Min(0)
        @Max(50)
        String description,

        @NotNull(message = "Price shouldn't be empty")
        @Min(0)
        @Max(50)
        double price,

        @NotNull(message = "Price shouldn't be empty")
        @Min(0)
        @Max(50)
        int quantity
) {
    public static BookDTO from(BookEntity bookEntity) {
        return new BookDTO(bookEntity.getId(), bookEntity.getTitle(), bookEntity.getAuthor(), bookEntity.getDescription(),
                bookEntity.getPrice(), bookEntity.getQuantity());
    }
}
