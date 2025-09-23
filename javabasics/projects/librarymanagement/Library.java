package projects.librarymanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
  private static List<Book> books = new ArrayList<Book>();
  private static List<Member> members = new ArrayList<Member>();
  private static List<Librarian> librariance = new ArrayList<Librarian>();
  private static int personId = 0;
  private static int bookId = 0;
  private static int memberId = 0;

  public static boolean registerLibrarian(Scanner sc) {
    System.out.print("Enter a Name of Librarian := ");
    String personName = sc.next();
    sc.nextLine();
    System.out.print("\nEnter a Contact Number of Librarian := ");
    String personContactNumber = sc.nextLine();
    System.out.print("\nEnter a Username of Librarian := ");
    String personUsername = sc.nextLine();
    System.out.print("\nEnter a Password of Librarian := ");
    String personPassword = sc.nextLine();
    Librarian l = new Librarian(personName, personContactNumber, ++personId, personUsername,
        personPassword);
    librariance.add(l);
    return true;
  }

  public static boolean registerMember(Scanner sc) {
    System.out.print("Enter a Name of Member := ");
    String personName = sc.next();
    sc.nextLine();
    System.err.print("\nEnter a Contact Number of Member := ");
    String personContactNumber = sc.nextLine();
    System.out.print("\nEnter a Username of Librarian := ");
    String personUsername = sc.nextLine();
    System.out.print("\nEnter a Password of Librarian := ");
    String personPassword = sc.nextLine();
    Member member = new Member(++personId, personName, personContactNumber, personUsername, personPassword);
    members.add(member);
    return true;
  }

  public static void librarianMenu() {
    while (true) {
      System.out.println("========= Librarian Menu =========\n" + //
          "1. Add Book\n" + //
          "2. Remove Book\n" + //
          "3. Search Book\n" + //
          "4. View All Books\n" + //
          "5. Register Member\n" + //
          "0. Logout\n" + //
          "==================================\n" + //
          "Enter choice:\n" + //
          "");
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();

      switch (n) {
        case 1:
          sc.nextLine();
          System.out.print("Book title := ");
          String bookTitle = sc.nextLine();
          System.out.print("Book Author := ");
          String bookAuthor = sc.nextLine();

          System.out.print("Book Category := ");
          String bookCategory = sc.nextLine();

          System.out.print("Book Total Copies := ");
          int bookTotalCopies = sc.nextInt();

          Book b = new Book(bookId++, bookTitle, bookAuthor, bookCategory, bookTotalCopies);
          books.add(b);
          System.out.println("Book Added Successfully");
          break;

        case 2:
          System.out.print("Enter a book id := ");
          int bookid = sc.nextInt();
          books.remove(bookid);
          break;
        case 3:
          sc.nextLine();
          System.out.print("Enter a name to search book := ");
          String bookName = sc.nextLine();
          books.forEach(book -> {
            if (bookName.equals(book.title) || bookName.equals(book.category) || bookName.equals(book.author)) {
              book.displayBookDetails();
              return;
            }
          });
          break;
        case 4:
          System.out.println("*********** Books ************");
          for (Book book : books) {
            book.displayBookDetails();
          }
          System.out.println("*******************************");
          break;

        case 5:
          sc.nextLine();
          System.out.print("Enter a Memeber name := ");
          String memberName = sc.nextLine();
          System.out.print("Enter a Memeber Contact Number := ");
          String memberContactNumber = sc.nextLine();
          System.out.print("Enter a Memeber Username := ");
          String memberUsername = sc.nextLine();
          System.out.print("Enter a Memeber password := ");
          String memberPassword = sc.nextLine();

          Member m = new Member(memberId++, memberName, memberContactNumber, memberUsername, memberPassword);
          members.add(m);
          System.out.println("Member Successfully created");
          break;

        case 0:
          System.out.println("Returning to Back Main Menu...");

          return;
        default:
          System.out.println("invaid Input !!!");
          break;
      }

    }

  }

  public static void memberMenu(int memberId) {
    Member currentMember = members.get(memberId);

    while (true) {
      System.out.println("========= Librarian Menu =========\n" + //
          "1. Borrow Book\n" + //
          "2. Return Book\n" + //
          "3. view all Book\n" + //
          "0. Logout\n" + //
          "==================================\n" + //
          "Enter choice:\n" + //
          "");
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      switch (n) {
        case 1:
          // if (currentMember.getBorrowBooks().size() == 0) {
          // System.out.println("You dont have any book borrow");
          // return;
          // }
          if (currentMember.isBookExist(bookId)) {
            System.out.println("Book is Already Borrow, you cant borrow Same Book");
            return;
          }
          System.err.print("if u want to any book to borrrow please enter bookid := ");
          int bookId = sc.nextInt();

          Book book = books.get(bookId);
          BorrowBook borrowBook = new BorrowBook(bookId, book.title, book.author, book.category);
          book.decreaseQunatity(1);
          System.out.println("Total Copies := " + book.totalCopies);
          currentMember.borrowBook(borrowBook);
          System.out.println("Book Successfuly Borrowed");
          break;
        case 3:
          List<BorrowBook> borrowBooks = currentMember.getBorrowBooks();
          for (BorrowBook bok : borrowBooks) {
            bok.displayBookDetails();
          }
          break;
        case 0:
          return;
        default:
          throw new AssertionError();
      }
    }
  }

  public static void main(String[] args) {
    while (true) {
      try {

        System.out.println("\n\nWelcome to my Library");
        System.out.println("\n1. Register Librarian\n" + //
            "\n2. show librarians\n3. Login as Librarian\n4. Login as a memeber");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
          case 1:
            if (registerLibrarian(sc)) {
              System.out.println("Librarian Add Successfully!!");
            } else {
              System.out.println("Failed To Add Librarian");
            }
            break;
          case 2:
            System.out.println("Libririan Details");
            for (Librarian lib : librariance) {
              System.out.println("--------------------------------");
              lib.displayDetails();
            }
            break;
          case 3:
            sc.nextLine();
            System.out.print("Enter Username := ");
            String username = sc.nextLine();
            System.out.print("Enter Password := ");
            String password = sc.nextLine();
            if (librariance.size() == 0) {
              System.out.println("There is No any Librarian Regsiter, Please Register as a librarian");
              break;
            }
            boolean isUserFound = false;
            for (Librarian l : librariance) {
              if (username.equals(l.username) && password.equals(l.password)) {
                System.out.println("Login Successfully\n!!!");
                isUserFound = true;
                librarianMenu();
              }
            }
            if (!isUserFound) {
              System.out.println("Invalid Username and Password");
              break;
            }
            break;

          case 4:
            sc.nextLine();
            System.out.print("Enter Username := ");
            String memberUsername = sc.nextLine();
            System.out.print("Enter Password := ");
            String memberPassword = sc.nextLine();
            if (librariance.size() == 0) {
              System.out.println("There is No any Librarian Regsiter, Please Register as a librarian");
              break;
            }
            boolean isMemberFound = false;
            for (Member m : members) {
              if (memberUsername.equals(m.username) && memberPassword.equals(m.password)) {
                System.out.println("Login Successfully\n!!!");
                isMemberFound = true;
                memberMenu(m.getMemberId());
              }
            }
            if (!isMemberFound) {
              System.out.println("Invalid Username and Password");
              break;
            }
            break;

          default:
            System.out.println("invalid Input!!!");
            break;
        }
      } catch (Exception e) {
        System.out.println(e);
      }
    }

  }
}
