package projects.librarymanagement;

public class BorrowBook {
  private int borrowBookId;
  private String borrowBookTitle;
  private String borrowBookAuthor;
  private String borrowBookCategory;

  public BorrowBook(int borrowBookId, String borrowBookTitle, String borrowBookAuthor, String borrowBookCategory) {
    this.borrowBookId = borrowBookId;
    this.borrowBookTitle = borrowBookTitle;
    this.borrowBookAuthor = borrowBookAuthor;
    this.borrowBookCategory = borrowBookCategory;
  }

  public int getBorrowBookId() {
    return borrowBookId;
  }

  public String getBorrowBookTitle() {
    return borrowBookTitle;
  }

  public String getBorrowBookAuthor() {
    return borrowBookAuthor;
  }

  public String getBorrowBookCategory() {
    return borrowBookCategory;
  }

  @Override
  public String toString() {
    return String.format(
        "Book id: %d, Name: %s, Author: %s, Category: %s",
        borrowBookId, borrowBookTitle, borrowBookAuthor, borrowBookCategory);
  }
}
