package projects.librarymanagement;

public class Librarian extends Person {

  private int librarianId;

  Librarian(String name, String contactNumber, int personId, String username, String password) {
    this.name = name;
    this.contactNumber = contactNumber;
    this.librarianId = personId;
    this.username = username;
    this.password = password;
  }

}
