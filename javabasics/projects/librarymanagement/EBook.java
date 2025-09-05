package projects.librarymanagement;

public class EBook extends Book {
  private double fileSizeMB;

  public EBook(int id, String title, String author, double size) {
    super(id, title, author);
    this.fileSizeMB = size;
  }

  @Override
  public void displayBookDetails() {
    System.out.printf("{\n\tBook Name := %s\n\tBook Author := %s\n\tBook Size := %.2f MB\n}\n\n", this.getBookTitle(),
        this.getBookAuthor(),
        this.fileSizeMB);
  }
}
