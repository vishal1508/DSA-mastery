package javabasics.collectionframework.list.hashmaps;

import java.util.HashMap;
import java.util.Objects;

public class HashMapExample {
  public static void main(String[] args) {
    HashMap<Integer, String> h = new HashMap<>();
    h.put(1, "apple");
    h.put(2, "grapes");
    h.put(3, "mango");

    System.out.println(h.keySet());

    for (int i : h.keySet()) {
      System.out.println(h.get(i));
    }

    HashMap<Student, String> s = new HashMap<>();

    Student s1 = new Student(1, "Vishal");
    Student s2 = new Student(2, "Rajesh");
    Student s3 = new Student(1, "Vishal");

    s.put(s1, "Enginneer");
    s.put(s2, "Designer");
    s.put(s3, "Manager");

    for (Student st : s.keySet()) {
      System.out.println(st);
    }

    System.out.println("Size : " + s.size());
    System.out.println(s.get(s3));
    System.out.println(s.get(s1));

  }
}

class Student {
  int id;
  String name;

  public Student(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return this.id + " : " + this.name;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

  @Override
  public boolean equals(Object obj) {
    System.out.println("obj : " + obj + " : this : " + this);
    if (obj == this) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    System.out.println("obj class: " + obj.getClass() + " : class : " + getClass());
    if (obj.getClass() != getClass()) {
      return false;
    }
    Student s = (Student) obj;
    return id == s.getId() && Objects.equals(name, s.getName());
  }

}
