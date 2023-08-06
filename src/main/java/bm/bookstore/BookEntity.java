package bm.bookstore;

public record BookEntity(int id, String title, String author, String description, double price, int quantity) {
    @Override
    public String toString() {
        return "-----------\nid=" + id + "\ntitle=" + title + "\nauthor=" + author + "\ndescription=" + description + "\nprice=" + price + "\nquantity=" + quantity + "\n----------";
    }
}
