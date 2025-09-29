package collectionframework.list.comparator_practice;

import java.util.ArrayList;

public class Practice3 {
  public static void main(String[] args) throws Exception {
    ArrayList<Student> students = new ArrayList<>();

    students.add(new Student(12, "Vishal"));
    students.add(new Student(12, "Rajesh"));
    students.add(new Student(13, "Arjun"));
    students.add(new Student(13, "Bhim"));
    students.add(new Student(45, "Krishna"));

    students.sort((s1, s2) -> {
      if (s1.getMarks() - s2.getMarks() > 0) {
        return 1;
      } else if (s1.getMarks() - s2.getMarks() < 0) {
        return -1;
      } else {
        return s1.getName().compareTo(s2.getName());
      }

    });
    for (Student s : students) {
      System.out.println(s.getMarks() + " : " + s.getName());
    }
  }
}

class Student {
  int marks;
  String name;

  public Student(int marks, String name) {
    this.marks = marks;
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public int getMarks() {
    return this.marks;
  }

}
