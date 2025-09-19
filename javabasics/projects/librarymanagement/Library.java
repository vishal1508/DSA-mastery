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
          "6. Logout\n" + //
          "==================================\n" + //
          "Enter choice:\n" + //
          "");
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();

      switch (n) {
        case 1:
          System.out.print("Book title := ");
          String bookTitle = sc.nextLine();
          sc.nextLine();
          System.out.print("Book Author := ");
          String bookAuthor = sc.nextLine();
          sc.nextLine();
          System.out.print("Book Category := ");
          String bookCategory = sc.nextLine();
          System.out.print("Book Total Copies := ");
          int bookTotalCopies = sc.nextInt();

          Book b = new Book(bookId++, bookTitle, bookAuthor, bookCategory, bookTotalCopies);
          books.add(b);
          System.out.println("Book Added Successfully");
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

  public static void main(String[] args) {
    while (true) {
      try {

        System.out.println("\n\nWelcome to my Library");
        System.out.println("\n1. Register Librarian\\n" + //
            "\n3. show librarians\n4. Login as Librarian\n5. Login as a memeber");
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
            System.out.println("\nEnter Username := ");
            String username = sc.nextLine();
            sc.nextLine();
            System.out.println("\nEnter Password := ");
            String password = sc.nextLine();
            if (librariance.size() == 0) {
              System.out.println("There is No any Librarian Regsiter, Please Register as a librarian");
            }
            System.out.println(username + "" + password);
            for (Librarian l : librariance) {
              if (username.equals(l.username) && password.equals(l.password)) {
                System.out.println("Login Successfully\n!!!");
                librarianMenu();
              }
            }
            System.out.println("is back");
            break;
          case 4:
            System.out.println("Libririan Details");
            for (Librarian lib : librariance) {
              System.out.println("--------------------------------");
              lib.displayDetails();
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
