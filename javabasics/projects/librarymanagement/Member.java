package projects.librarymanagement;

import java.util.ArrayList;
import java.util.List;

public class Member extends Person {
  private int memberId;

  private List<BorrowBook> borrowBooks;

  public Member(int memberId, String name, String contactNumber, String username, String password) {
    this.memberId = memberId;
    this.name = name;
    this.contactNumber = contactNumber;
    this.username = username;
    this.password = password;
    this.borrowBooks = new ArrayList<BorrowBook>();
  }

  public void borrowBook(BorrowBook b) {
    borrowBooks.add(b);
  }

  public boolean isBookExist(int bookId) {

    if (borrowBooks.get(bookId).getBorrowBookId() == bookId && borrowBooks.size() > 0) {
      return true;
    }
    return false;
  }

  public List<BorrowBook> getBorrowBooks() {
    return this.borrowBooks;
  }
  // public void returnBook(int bookid){

  // }
  public int getMemberId() {
    return this.memberId;
  }
}
