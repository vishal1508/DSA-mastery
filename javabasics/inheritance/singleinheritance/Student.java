package inheritance.singleinheritance;

public class Student extends Person {
  String standard;
  int rollno;
  int name;

  public Student() {
    super();
    System.out.println("Student Constructore is called");
  }

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
    return super.name;

  }

  public int getStudentAge() {
    return getAge();
  }
}
