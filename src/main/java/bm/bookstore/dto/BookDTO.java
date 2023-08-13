package bm.bookstore.dto;

import bm.bookstore.entities.BookEntity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record BookDTO(
        @NotNull
        int id,

        @NotNull
        @Min(1)
        @Max(120)
        String title,

        @NotNull
        String author,

        @NotNull
        String description,

        @NotNull
        double price,

        @NotNull
        int quantity
) {
    public static BookDTO from(BookEntity bookEntity) {
        return new BookDTO(bookEntity.getId(), bookEntity.getTitle(), bookEntity.getAuthor(), bookEntity.getDescription(),
                bookEntity.getPrice(), bookEntity.getQuantity());
    }
}
