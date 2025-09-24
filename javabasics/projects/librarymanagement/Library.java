package projects.librarymanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {

  private static List<Book> books = new ArrayList<>();
  private static List<Member> members = new ArrayList<>();
  private static List<Librarian> librarians = new ArrayList<>();

  private static int personIdCounter = 0;
  private static int bookIdCounter = 0;

  private static Scanner sc = new Scanner(System.in);

  // ------------------- Registration -------------------
  public static void registerLibrarian() {
    System.out.print("Enter Librarian Name: ");
    String name = sc.nextLine();
    System.out.print("Enter Contact Number: ");
    String contact = sc.nextLine();
    System.out.print("Enter Username: ");
    String username = sc.nextLine();
    System.out.print("Enter Password: ");
    String password = sc.nextLine();

    Librarian l = new Librarian(++personIdCounter, name, contact, username, password);
    librarians.add(l);
    System.out.println("Librarian registered successfully!");
  }

  public static void registerMember() {
    System.out.print("Enter Member Name: ");
    String name = sc.nextLine();
    System.out.print("Enter Contact Number: ");
    String contact = sc.nextLine();
    System.out.print("Enter Username: ");
    String username = sc.nextLine();
    System.out.print("Enter Password: ");
    String password = sc.nextLine();

    Member m = new Member(++personIdCounter, name, contact, username, password);
    members.add(m);
    System.out.println("Member registered successfully!");
  }

  // ------------------- Utility -------------------
  private static Book getBookById(int bookId) {
    for (Book b : books) {
      if (b.getBookId() == bookId)
        return b;
    }
    return null;
  }

  private static Member getMemberById(int memberId) {
    for (Member m : members) {
      if (m.getMemberId() == memberId)
        return m;
    }
    return null;
  }

  private static Librarian loginLibrarian() {
    System.out.print("Enter Username: ");
    String username = sc.nextLine();
    System.out.print("Enter Password: ");
    String password = sc.nextLine();

    for (Librarian l : librarians) {
      if (l.getUsername().equals(username) && l.checkPassword(password)) {
        System.out.println("Login successful!");
        return l;
      }
    }
    System.out.println("Invalid username or password.");
    return null;
  }

  private static Member loginMember() {
    System.out.print("Enter Username: ");
    String username = sc.nextLine();
    System.out.print("Enter Password: ");
    String password = sc.nextLine();

    for (Member m : members) {
      if (m.getUsername().equals(username) && m.checkPassword(password)) {
        System.out.println("Login successful!");
        return m;
      }
    }
    System.out.println("Invalid username or password.");
    return null;
  }

  // ------------------- Librarian Menu -------------------
  private static void librarianMenu(Librarian l) {
    while (true) {
      System.out.println("\n=== Librarian Menu ===");
      System.out.println("1. Add Book");
      System.out.println("2. Remove Book");
      System.out.println("3. Search Book");
      System.out.println("4. View All Books");
      System.out.println("5. Register Member");
      System.out.println("0. Logout");
      int choice = getIntInput("Enter choice: ");
      sc.nextLine();

      switch (choice) {
        case 1:
          System.out.print("Book Title: ");
          String title = sc.nextLine();
          System.out.print("Book Author: ");
          String author = sc.nextLine();
          System.out.print("Book Category: ");
          String category = sc.nextLine();
          int copies = getIntInput("Total Copies: ");

          sc.nextLine();

          Book b = new Book(++bookIdCounter, title, author, category, copies);
          books.add(b);
          System.out.println("Book added successfully!");
          break;

        case 2:
          System.out.print("Enter Book ID to remove: ");
          int removeId = sc.nextInt();
          sc.nextLine();
          Book bookToRemove = getBookById(removeId);
          if (bookToRemove != null) {
            books.remove(bookToRemove);
            System.out.println("Book removed successfully!");
          } else {
            System.out.println("Book not found!");
          }
          break;

        case 3:
          System.out.print("Enter keyword to search (title/author/category): ");
          String keyword = sc.nextLine().toLowerCase();
          boolean found = false;
          for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword) ||
                book.getAuthor().toLowerCase().contains(keyword) ||
                book.getCategory().toLowerCase().contains(keyword)) {
              book.toString();
              found = true;
            }
          }
          if (!found)
            System.out.println("No books found matching keyword.");
          break;

        case 4:
          if (books.isEmpty()) {
            System.out.println("No books available.");
            break;
          }
          System.out.println("=== All Books ===");
          for (Book book : books) {
            System.out.println(book);
          }
          break;

        case 5:
          registerMember();
          break;

        case 0:
          System.out.println("Logging out...");
          return;

        default:
          System.out.println("Invalid choice!");
      }
    }
  }

  // ------------------- Member Menu -------------------
  private static void memberMenu(Member m) {
    while (true) {
      System.out.println("\n=== Member Menu ===");
      System.out.println("1. Borrow Book");
      System.out.println("2. Return Book");
      System.out.println("3. View Borrowed Books");
      System.out.println("0. Logout");
      int choice = getIntInput("Enter choice: ");

      sc.nextLine();

      switch (choice) {
        case 1:
          int borrowId = getIntInput("Enter Book ID to borrow: ");
          sc.nextLine();
          Book bookToBorrow = getBookById(borrowId);
          if (bookToBorrow == null) {
            System.out.println("Book not found!");
            break;
          }
          if (!bookToBorrow.isAvailable()) {
            System.out.println("No copies available!");
            break;
          }
          if (m.isBookExist(borrowId)) {
            System.out.println("You already borrowed this book!");
            break;
          }

          BorrowBook borrowed = new BorrowBook(bookToBorrow.getBookId(),
              bookToBorrow.getTitle(),
              bookToBorrow.getAuthor(),
              bookToBorrow.getCategory());
          m.borrowBook(borrowed);
          bookToBorrow.decreaseQuantity(1);
          System.out.println("Book borrowed successfully!");
          break;

        case 2:
          System.out.print("Enter Book ID to return: ");
          int returnId = sc.nextInt();
          sc.nextLine();
          if (!m.isBookExist(returnId)) {
            System.out.println("You have not borrowed this book!");
            break;
          }
          BorrowBook toReturn = null;
          for (BorrowBook bReturn : m.getBorrowBooks()) {
            if (bReturn.getBorrowBookId() == returnId) {
              toReturn = bReturn;
              break;
            }
          }
          if (toReturn != null) {
            m.returnBook(returnId);
            Book originalBook = getBookById(returnId);
            if (originalBook != null)
              originalBook.increaseQuantity(1);
            System.out.println("Book returned successfully!");
          }
          break;

        case 3:
          List<BorrowBook> borrowedBooks = m.getBorrowBooks();
          if (borrowedBooks.isEmpty()) {
            System.out.println("You have not borrowed any books.");
          } else {
            System.out.println("=== Borrowed Books ===");
            for (BorrowBook bBook : borrowedBooks) {
              System.out.println(bBook);
            }
          }
          break;

        case 0:
          System.out.println("Logging out...");
          return;

        default:
          System.out.println("Invalid choice!");
      }
    }
  }

  // ------------------- Main Menu -------------------
  public static void main(String[] args) {

    while (true) {
      System.out.println("\n=== Library System ===");
      System.out.println("1. Register Librarian");
      System.out.println("2. Show Librarians");
      System.out.println("3. Login as Librarian");
      System.out.println("4. Login as Member");
      System.out.println("0. Exit");
      int choice = getIntInput("Enter choice: ");

      sc.nextLine();

      switch (choice) {
        case 1:
          registerLibrarian();
          break;

        case 2:
          if (librarians.isEmpty()) {
            System.out.println("No librarians registered.");
          } else {
            System.out.println("=== Librarians ===");
            for (Librarian l : librarians) {
              l.toString();
            }
          }
          break;

        case 3:
          if (librarians.isEmpty()) {
            System.out.println("No librarians registered.");
            break;
          }
          Librarian loggedInL = loginLibrarian();
          if (loggedInL != null)
            librarianMenu(loggedInL);
          break;

        case 4:
          if (members.isEmpty()) {
            System.out.println("No members registered.");
            break;
          }
          Member loggedInM = loginMember();
          if (loggedInM != null)
            memberMenu(loggedInM);
          break;

        case 0:
          System.out.println("Exiting Library System...");
          sc.close();
          System.exit(0);

        default:
          System.out.println("Invalid choice!");
      }
    }
  }

  private static int getIntInput(String prompt) {
    while (true) {
      try {
        System.out.print(prompt);
        int input = sc.nextInt();
        sc.nextLine(); // consume newline
        return input;
      } catch (Exception e) {
        System.out.println("Invalid input! Please enter a number.");
        sc.nextLine(); // clear invalid input
      }
    }
  }

}
