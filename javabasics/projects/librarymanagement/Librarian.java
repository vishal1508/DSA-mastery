package projects.librarymanagement;

public class Librarian extends Person {
  private int librarianId;

  public Librarian(int librarianId, String name, String contactNumber, String username, String password) {
    super(name, contactNumber, username, password);
    this.librarianId = librarianId;
  }

  public int getLibrarianId() {
    return librarianId;
  }

  @Override
  public String toString() {
    return String.format("Librarian Id: %d, Name: %s, Contact: %s", librarianId, getName(), getContactNumber());
  }
}
