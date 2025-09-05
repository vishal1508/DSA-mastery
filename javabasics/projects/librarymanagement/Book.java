package projects.librarymanagement;

public class Book {
  private int id;

  private String title;

  private String author;

  public Book(int id, String title, String author) {
    this.id = id;
    this.title = title;
    this.author = author;
  }

  public int getBookId() {
    return this.id;
  }

  public String getBookTitle() {
    return this.title;
  }

  public String getBookAuthor() {
    return this.author;
  }

  public void displayBookDetails() {
    System.out.printf("Book Name := %s\nBook Author := %s", this.title, this.author);
  }
}
