package projects.librarymanagement;

public class Book {
  private int id = 1;

  private String title;

  private String author;

  private String category;

  private boolean isAvailable = false;
  private int totalCopies; // total available in library

  public Book(int id, String title, String author, String category, int totalCopies) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.category = category;
    this.isAvailable = true;
    this.totalCopies = totalCopies;

  }

  public void displayBookDetails() {
    System.out.printf("Book Name := %s\nBook Author := %s \nBook Category : %s\n Availablity%b", this.title,
        this.author,
        this.category, this.isAvailable);
  }
}
