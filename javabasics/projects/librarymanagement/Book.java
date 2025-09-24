package projects.librarymanagement;

public class Book {
  private int id;
  private String title;
  private String author;
  private String category;
  private int totalCopies; // total copies available in library

  public Book(int id, String title, String author, String category, int totalCopies) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.category = category;
    this.totalCopies = totalCopies;
  }

  public int getBookId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public String getCategory() {
    return category;
  }

  public int getTotalCopies() {
    return totalCopies;
  }

  public boolean isAvailable() {
    return totalCopies > 0;
  }

  public void decreaseQuantity(int quantity) {
    if (quantity <= totalCopies) {
      totalCopies -= quantity;
    } else {
      System.out.println("Not enough copies available!");
    }
  }

  public void increaseQuantity(int quantity) {
    totalCopies += quantity;
  }

  @Override
  public String toString() {
    return String.format(
        "Book id: %d, Name: %s, Author: %s, Category: %s, Available: %b, Total Copies: %d",
        id, title, author, category, isAvailable(), totalCopies);
  }
}
