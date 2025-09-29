package collectionframework.list.comparator_practice;

import java.util.ArrayList;
import java.util.Comparator;

public class Practice {
  public static void main(String[] args) {
    ArrayList<Book> books = new ArrayList<>();

    books.add(new Book(1, "Mathsssss", 122.22));
    books.add(new Book(2, "English", 100.34));
    books.add(new Book(3, "Physics", 132.53));
    books.add(new Book(4, "Chemistry", 145.32));

    books.sort(null);
    System.out.println("Sort by Price ascending order");
    books.forEach((s) -> System.out.println(s.getPrice() + " : " + s.getTitle()));
    System.out.println("\n Sort By Title Ascending ORider");
    books.sort(Comparator.comparing(Book::getTitle));
    books.forEach((s) -> System.out.println(s.getPrice() + " : " + s.getTitle()));

    System.out.println("\n Sort By String Lenght");
    books.sort((b1, b2) -> b1.getTitle().length() - b2.getTitle().length());
    books.forEach((s) -> System.out.println(s.getPrice() + " : " + s.getTitle()));
  }
}

class Book implements Comparable<Book> {
  int id;
  double price;
  String title;

  public Book(int id, String title, double price) {
    this.id = id;
    this.title = title;
    this.price = price;
  }

  public double getPrice() {
    return this.price;
  }

  public String getTitle() {
    return this.title;
  }

  @Override
  public int compareTo(Book b) {
    return Double.compare(this.price, b.price);
  }

}