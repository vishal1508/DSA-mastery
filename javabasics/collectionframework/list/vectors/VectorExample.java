package javabasics.collectionframework.list.vectors;

import java.util.Enumeration;
import java.util.Scanner;
import java.util.Vector;

public class VectorExample {
  public static void main(String[] args) {
    // Example: initial capacity 3, increment 2
    Vector<Student> students = new Vector<>(3, 2);
    Vector<Student> student_Clone = new Vector<>(3, 2);
    Scanner sc = new Scanner(System.in);
    int studentId = 0;
    int number;
    String name;
    double num;
    while (true) {
      System.out.println("\n===== Student Grades Manager =====");
      System.out.println("1. Add Student at End");
      System.out.println("2. Add Student at Specific Index");
      System.out.println("3. Remove First Student");
      System.out.println("4. Remove Last Student");
      System.out.println("5. Remove Student by Name");
      System.out.println("6. Remove Student by Index");
      System.out.println("7. Update Student Name or Score");
      System.out.println("8. View First Student");
      System.out.println("9. View Last Student");
      System.out.println("10. View Student by Index");
      System.out.println("11. Show All Students");
      System.out.println("12. Search Student by Name");
      System.out.println("13. Find Student Position");
      System.out.println("14. Show Total Students");
      System.out.println("15. Show Vector Capacity");
      System.out.println("16. Clear All Students");
      System.out.println("17. Clone Student Vector");
      System.out.println("18. Enumerate Students");
      System.out.println("0. Exit");
      System.out.println("==================================");

      System.out.print("Enter choice: ");
      number = sc.nextInt();

      switch (number) {
        case 0:
          System.out.println("Exiting program...");
          sc.close();
          return;

        case 1:
          sc.nextLine();
          System.out.print("enter a Student Name : ");
          name = sc.nextLine();
          System.out.print("enter a Student Score : ");
          num = sc.nextDouble();

          students.add(new Student(++studentId, name, num));
          System.out.println("Student Add Successfully");

          break;

        case 2:
          System.out.println("[LOG] Add Student at Specific Index selected");
          System.out.print("Enter position (0-based index): ");
          int index = sc.nextInt();
          sc.nextLine();
          System.out.print("enter a Student Name : ");
          name = sc.nextLine();
          System.out.print("enter a Student Score : ");
          num = sc.nextDouble();

          students.add(index, new Student(++studentId, name, num));
          System.out.println("Student Add Successfully");
          break;

        case 3:
          if (students.isEmpty()) {
            System.err.println("There is No Students!!");
            break;
          }
          students.remove(0);
          System.out.println(" Successfully Remove student from first place");
          System.out.println("[LOG] Remove First Student selected");
          break;

        case 4:
          if (students.isEmpty()) {
            System.err.println("There is No Students!!");
            break;
          }
          students.remove(students.size() - 1);
          System.out.println(" Successfully Remove student from Last place");
          System.out.println("[LOG] Remove Last Student selected");
          break;

        case 5:
          sc.nextLine();
          System.out.print("Ente Student Name : ");
          String temname = sc.nextLine();
          students.removeIf(s -> s.name.equals(temname));
          System.out.println("Student has been Remove Successfully");
          System.out.println("[LOG] Remove Student by Name selected");
          break;

        case 6:
          System.out.print("Enter position to remove student (0-based index): ");
          int idx4 = sc.nextInt();
          students.remove(idx4);
          System.out.println("Student has been Remove Successfully");
          System.out.println("[LOG] Remove Student by Index selected");
          break;

        case 7:
          System.out.print("Enter index to update : ");
          int idx5 = sc.nextInt();
          sc.nextLine();
          System.out.println("1. update name\n2. Update Score");
          switch (sc.nextInt()) {
            case 1:
              System.out.print("Enter Student Name : ");
              String sname = sc.nextLine();
              students.forEach(s -> {
                if (s.getId() == idx5) {
                  s.setName(sname);
                }
              });
              break;
            case 2:
              System.out.print("Enter Student Name : ");
              double sscore = sc.nextDouble();
              students.forEach(s -> {
                if (s.getId() == idx5) {
                  s.setScore(sscore);
                }
              });
              break;
            default:
              System.out.println("Invalid Choice");
              break;
          }
          System.out.println("[LOG] Update Student Name or Score selected");
          break;

        case 8:
          System.out.println("First Student Selected : " + students.get(0));
          System.out.println("[LOG] View First Student selected");
          break;

        case 9:
          System.out.println("last Student Selected : " + students.get(students.size() - 1));
          System.out.println("[LOG] View Last Student selected");
          break;

        case 10:
          System.out.print("Enter a Index to view student details : ");
          number = sc.nextInt();
          System.out.println("Student Details by Index : \n" + students.get(number));
          System.out.println("[LOG] View Student by Index selected");
          break;

        case 11:
          System.out.println("[LOG] Show All Students selected\n" + students);
          break;

        case 12:
          sc.nextLine();
          System.out.print("Enter a student name : ");
          name = sc.nextLine();
          for (Student s : students) {
            if (s.name.equalsIgnoreCase(name)) {
              System.out.println(s.toString());
              break;
            }

          }
          System.out.println("[LOG] Search Student by Name selected");
          break;

        case 13:
          System.out.println("[LOG] Find Student Position selected");
          break;

        case 14:
          System.out.println("Total Students := " + students.size());
          System.out.println("[LOG] Show Total Students selected");
          break;

        case 15:
          System.out.println("students Capacity := " + students.capacity());
          System.out.println("[LOG] Show Vector Capacity selected");
          break;

        case 16:
          students.clear();
          System.out.println("[LOG] Clear All Students selected");
          break;

        case 17:
          student_Clone = (Vector<Student>) students.clone();
          if (student_Clone.size() == 0) {
            System.out.println("failed to clone students data");
            break;
          }
          System.out.println("[LOG] Clone Student Vector selected");
          break;

        case 18:
          Enumeration<Student> estudent = students.elements();
          while (estudent.hasMoreElements()) {
            Student tempStudent = estudent.nextElement();
            System.out.println(tempStudent.toString());
          }
          System.out.println("[LOG] Enumerate Students selected");
          break;

        default:
          System.out.println("Invalid choice! Please try again.");
          break;
      }
    }

  }
}

class Student {
  private int id;
  String name;
  private double score;

  public Student(int id, String name, double score) {
    this.id = id;
    this.name = name;
    this.score = score;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getScore() {
    return score;
  }

  public void setScore(double score) {
    this.score = score;
  }

  @Override
  public String toString() {
    return "{ID: " + id + ", Name: " + name + ", Score: " + score + "}";
  }

}
