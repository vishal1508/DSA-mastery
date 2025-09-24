package projects.librarymanagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Member extends Person {
  private int memberId;
  private List<BorrowBook> borrowBooks;

  public Member(int memberId, String name, String contactNumber, String username, String password) {
    super(name, contactNumber, username, password);
    this.memberId = memberId;
    this.borrowBooks = new ArrayList<>();
  }

  public void borrowBook(BorrowBook b) {
    borrowBooks.add(b);
  }

  public void returnBook(int bookId) {
    borrowBooks.removeIf(b -> b.getBorrowBookId() == bookId);
  }

  public boolean isBookExist(int bookId) {
    for (BorrowBook b : borrowBooks) {
      if (b.getBorrowBookId() == bookId)
        return true;
    }
    return false;
  }

  public List<BorrowBook> getBorrowBooks() {
    return Collections.unmodifiableList(borrowBooks);
  }

  public int getMemberId() {
    return memberId;
  }
}
