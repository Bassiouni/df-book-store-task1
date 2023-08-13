package bm.bookstore.entities;

import bm.bookstore.dto.BookDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity(name = "books")
@Table(name = "books")
public class BookEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "name", length = 50, nullable = false, unique = false)
	private String title;

	@Column(name = "author", length = 50, nullable = false, unique = false)
	private String author;

	@Column(name = "description", length = 50, nullable = false, unique = false)
	private String description;

	@Column(name = "price", length = 50, nullable = false, unique = false)
	private double price;

	@Column(name = "quantity", length = 50, nullable = false, unique = false)
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

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
