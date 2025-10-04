package javabasics.collectionframework.list.comparableminiproject;

import java.util.Comparator;

public class Student implements Comparable<Student> {
  int id;
  String name;
  double marks;
  int age;

  public Student(int id, String name, double marks, int age) {
    this.id = id;
    this.name = name;
    this.marks = marks;
    this.age = age;
  }

  public int getAge() {
    return age;
  }

  public int getId() {
    return id;
  }

  public double getMarks() {
    return marks;
  }

  public String getName() {
    return name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setMarks(double marks) {
    this.marks = marks;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public int compareTo(Student s) {
    return s.id - this.id;
  }

  public final static Comparator<Student> compareByName = Comparator.comparing(Student::getName);
  public final static Comparator<Student> compareByMarks = Comparator.comparingDouble(Student::getMarks).reversed();
  public final static Comparator<Student> compareAgeandName = (s1, s2) -> {
    if (s1.age > s2.age) {
      return 1;
    } else if (s1.age < s2.age) {
      return -1;
    } else {
      return s1.name.compareTo(s2.name);
    }
  };

  @Override
  public String toString() {
    return "\n" + this.id + " : " + this.name + " : " + this.marks + " : " + this.age + "\n";
  }

}
