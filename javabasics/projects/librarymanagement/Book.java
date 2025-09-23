package projects.librarymanagement;

public class Book {
  private int id = 1;

  String title;

  String author;

  String category;

  private boolean isAvailable = false;
  int totalCopies; // total available in library

  public Book(int id, String title, String author, String category, int totalCopies) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.category = category;
    this.isAvailable = true;
    this.totalCopies = totalCopies;

  }

  public void decreaseQunatity(int quantity) {
    this.totalCopies -= quantity;
  }

  public int getBookId() {
    return this.id;
  }

  public void displayBookDetails() {
    System.out.println("================================================");
    System.out.printf(
        "\nBook id := %d\nBook Name := %s\nBook Author := %s \nBook Category := %s\n Availablity := %b\ntotal Copies := %d\n",
        this.id, this.title,
        this.author,
        this.category, this.isAvailable, this.totalCopies);
    System.out.println("================================================");
  }
}
