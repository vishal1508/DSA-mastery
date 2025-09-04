package encapsulation;

public class Book {
  private String title;
  private String author;

public Book(String title,String author){
  this.author = author;
  this.title = title;
}
public String getBook(){
  return "title is :=> "+this.title+"\nAuthor is :=> "+this.author;
}
}
