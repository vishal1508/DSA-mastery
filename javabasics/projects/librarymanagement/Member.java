package projects.librarymanagement;

import java.util.ArrayList;
import java.util.List;

public class Member extends Person {
  private int memberId;

  private List<Book> borrowBooks;

  public Member(int memberId, String name, String contactNumber, String username, String password) {
    this.memberId = memberId;
    this.name = name;
    this.contactNumber = contactNumber;
    this.username = username;
    this.password = password;
    this.borrowBooks = new ArrayList<Book>();
  }

  public void borrowBook(Book b) {
    borrowBooks.add(b);
  }

  public List<Book> getBorrowBooks() {
    return this.borrowBooks;
  }

  public int getMemberId() {
    return this.memberId;
  }
}
