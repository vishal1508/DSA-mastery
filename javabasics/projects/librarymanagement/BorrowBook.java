package projects.librarymanagement;

public class BorrowBook {
  private int borrowBookId;
  String borrowBookTitle;
  String borrowBookAuthor;
  String borrowBookCategory;

  public BorrowBook(int borrowBookId, String borrowBookTitle, String borrowBookAuthor, String borrowBookCategoy) {
    this.borrowBookAuthor = borrowBookAuthor;
    this.borrowBookCategory = borrowBookCategoy;
    this.borrowBookId = borrowBookId;
    this.borrowBookTitle = borrowBookTitle;
  }

  public int getBorrowBookId() {
    return this.borrowBookId;
  }

  public void displayBookDetails() {
    System.out.println("================================================");
    System.out.printf(
        "\nBook id := %d\nBook Name := %s\nBook Author := %s \nBook Category := %s\n",
        this.borrowBookId, this.borrowBookTitle,
        this.borrowBookAuthor,
        this.borrowBookCategory);
    System.out.println("================================================");
  }

}
