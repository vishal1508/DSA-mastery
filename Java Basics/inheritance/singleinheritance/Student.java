package inheritance.singleinheritance;

public class Student extends Person {
  String standard;
  int rollno;

  public void setStudentDetails(String name, int age, String standard, int rollno) {
    this.standard = standard;
    setPersonDetail(age, name);
    this.rollno = rollno;
  }

  public String getStudentStandard() {
    return this.standard;
  }

  public int getStudentRollNumber() {
    return this.rollno;
  }

  public String getStudentName() {
    return getName();
  }

  public int getStudentAge() {
    return getAge();
  }
}
