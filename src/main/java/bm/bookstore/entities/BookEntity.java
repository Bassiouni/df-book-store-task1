package bm.bookstore.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BookEntity
{
    private int id;
    private String title;
    private String author;
    private String description;
    private double price;
    private int quantity;

    public void replaceWith(BookEntity bookEntity) {
        this.title = bookEntity.getTitle();
        this.author = bookEntity.getAuthor();
        this.description = bookEntity.getDescription();
        this.price = bookEntity.getPrice();
        this.quantity = bookEntity.getQuantity();
    }
}
