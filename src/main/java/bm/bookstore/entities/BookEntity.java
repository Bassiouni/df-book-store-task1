package bm.bookstore.entities;

import bm.bookstore.dto.BookDTO;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity(name = "books")
@Table(name = "books")
public class BookEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "name", length = 50, nullable = false)
	private String title;

	@Column(name = "author", length = 50, nullable = false)
	private String author;

	@Column(name = "description", length = 50, nullable = false)
	private String description;

	@Column(name = "price", length = 50, nullable = false)
	private double price;

	@Column(name = "quantity", length = 50, nullable = false)
	private int quantity;

	public BookEntity() {
	}

	public BookEntity(int id, String title, String author, String description, double price, int quantity) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "BookEntity{" +
				"id=" + id +
				", title='" + title + '\'' +
				", author='" + author + '\'' +
				", description='" + description + '\'' +
				", price=" + price +
				", quantity=" + quantity +
				'}';
	}

	public void replaceWith(BookEntity bookEntity) {
		this.title = bookEntity.getTitle();
		this.author = bookEntity.getAuthor();
		this.description = bookEntity.getDescription();
		this.price = bookEntity.getPrice();
		this.quantity = bookEntity.getQuantity();
	}

	public static BookEntity from(BookDTO bookDTO) {
		return new BookEntity(bookDTO.id(), bookDTO.title(), bookDTO.author(), bookDTO.description(), bookDTO.price(),
				bookDTO.quantity());
	}

	public void setId(int id) {
		this.id = id;
	}

}
