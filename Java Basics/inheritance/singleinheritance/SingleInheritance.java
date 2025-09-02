package inheritance.singleinheritance;

public class SingleInheritance {
  public static void main(String[] args) {
    Student s = new Student();
    s.setStudentDetails("Vishal", 12, "10th", 101);
    System.out.printf("The student name is %s and he is %d years old. He Study in the %s standard & his Roll no is %d",
        s.getStudentName(), s.getStudentAge(), s.getStudentStandard(), s.getStudentRollNumber());
  }
}
