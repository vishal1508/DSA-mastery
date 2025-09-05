package projects.librarymanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Library {
  static List<Book> b = new ArrayList<Book>();

  public static void main(String[] args) {
    // b.add(new EBook(101, "Maths", "gagan", 23.30));
    // b.add(new PrintBook(102, "Sciendce", "Alakh", 100));
    // b.add(new EBook(103, "Marathid", "Gitanjali", 23.30));
    // b.add(new PrintBook(1014, "English", "Aman", 200));

    System.out.println("1. Show all books\n2. Search Book By ID\n3. Search Book By Name\n4. add book");
    Scanner sc = new Scanner(System.in);
    int option = sc.nextInt();
    switch (option) {
      case 1:
        showAllBooks();
        break;
      case 2:

        System.out.println("enter a book ID :=> ");
        int id = sc.nextInt();
        findBookById(id);
        break;
      case 3:

        System.out.println("enter a book Title :=> ");
        String title = sc.next();
        findBookByTitle(title.trim());
        break;
      case 4:
        System.out.print("Enter a book title := ");
        String bookTitle = sc.nextLine();
        while (bookTitle.length() == 0) {
          System.out.print("Enter a book title := ");
          bookTitle = sc.nextLine();
        }
        sc.nextLine();
        System.out.print("Enter a book author := ");
        String bookAuthor = sc.nextLine();
        while (bookAuthor.length() == 0) {
          System.out.print("Enter a book title := ");
          bookTitle = sc.nextLine();
        }
        System.out.println("Choose Book type\n1. Ebook\n2. Paper Book");
        System.out.print("enter Option := ");
        int type = sc.nextInt();
        switch (type) {
          case 1:
            System.out.print("Enter a book Size := ");
            Double bookSizDouble = sc.nextDouble();
            b.add(new EBook(Math.round(1), bookTitle, bookAuthor, bookSizDouble));
            showAllBooks();
            break;
          case 2:
            System.out.print("Enter a book Pages := ");
            int bookPages = sc.nextInt();
            b.add(new PrintBook(Math.round(1), bookTitle, bookAuthor, bookPages));
            showAllBooks();
            break;
          default:
            System.out.println("Invalid Option of Book type Do you want to Continue type y else n");
            char c = sc.next().toLowerCase().charAt(0);
            if (c == 'y') {
              System.out.println("Choose Book type\n1. Ebook\n2. Paper Book");
              System.out.print("enter Option := ");
              type = sc.nextInt();
            } else {
              Library.main(args);
            }
        }

        break;
      default:
        System.out.println("Invalid Option");
        Library.main(args);
    }
  }

  public static void showAllBooks() {
    System.out.println("total Book is :=> " + b.size());
    for (Book book : b) {
      book.displayBookDetails();
    }
  }

  public static void findBookById(int id) {
    for (Book book : b) {
      if (book.getBookId() == id) {
        book.displayBookDetails();
        break;
      }
    }
  }

  public static void findBookByTitle(String title) {
    for (Book book : b) {
      if (book.getBookTitle().equalsIgnoreCase(title)) {
        book.displayBookDetails();
        break;
      }
    }
  }
}
