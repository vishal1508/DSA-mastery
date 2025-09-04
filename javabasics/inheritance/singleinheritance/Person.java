package inheritance.singleinheritance;

public class Person {
  private int age;
  String name;

  public Person() {
    System.out.println("Persons is callerd");
  }

  public void setPersonDetail(int age, String name) {
    this.age = age;
    this.name = name;
  }

  public int getAge() {
    return this.age;
  }

  public String getName() {
    return this.name;
  }
}
