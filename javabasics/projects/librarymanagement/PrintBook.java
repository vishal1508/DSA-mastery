package projects.librarymanagement;

public class PrintBook extends Book {
  int numberOfPages;

  public PrintBook(int id, String title, String author, int page) {
    super(id, title, author);
    this.numberOfPages = page;
  }

  @Override
  public void displayBookDetails() {
    System.out.printf("{\n\tBook Name := %s\n\tBook Author := %s\n\tBook Size := %d pages\n}\n\n", this.getBookTitle(),
        this.getBookAuthor(),
        this.numberOfPages);
  }
}
