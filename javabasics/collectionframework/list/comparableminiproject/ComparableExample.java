package javabasics.collectionframework.list.comparableminiproject;

import java.util.ArrayList;
import java.util.Scanner;

public class ComparableExample {
  public static void main(String[] args) {
    ArrayList<Student> s = new ArrayList<>();

    s.add(new Student(1, "Vishal", 23.45, 14));
    s.add(new Student(2, "Rajesh", 32.25, 13));
    s.add(new Student(3, "Vinay", 34.15, 14));
    s.add(new Student(4, "Sakaram", 43.35, 15));
    int id = 4;
    Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.println("1. Add Student\n" + //
          "2. View Students\n" + //
          "3. Sort by ID\n" + //
          "4. Sort by Name\n" + //
          "5. Sort by Marks (High to Low)\n" + //
          "6. Sort by Age then Name\n" + //
          "7. Exit\n" + //
          "");
      int choice = sc.nextInt();
      switch (choice) {
        case 1:
          sc.nextLine();
          System.out.print("Enter Student Name : ");
          String name = sc.nextLine();
          System.out.print("Enter Student Marks : ");
          double marks = sc.nextDouble();
          System.out.print("Enter Student Age : ");
          int age = sc.nextInt();
          s.add(new Student(++id, name, marks, age));
          break;
        case 2:
          System.out.println(s);
          break;
        case 3:
          s.sort(null);
          break;
        case 4:
          s.sort(Student.compareByName);
          break;
        case 5:
          s.sort(Student.compareByMarks);
          break;
        case 6:
          s.sort(Student.compareAgeandName);
          break;
        case 7:
          sc.close();
          return;
        default:
          throw new AssertionError();
      }
    }
  }
}
