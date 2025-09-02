
public class Encapsulation {
  public static void main(String[] args){
    encapsulation.Student s = new encapsulation.Student();
    encapsulation.Employee e = new encapsulation.Employee();
    encapsulation.Recatngle r = new encapsulation.Recatngle();
    encapsulation.Book b = new encapsulation.Book("Maths", "Vishal");
    s.setStudentName("Vishal");
    s.setStudentAge(18);
    e.setSalary(11000);
    System.out.println("Student Name is :=> "+s.getStudentName());
    System.out.println("Student Name is :=> "+s.getAge());
    System.out.println("Salary is :=> "+e.getSalary());
    r.setLengthAndWidth(30, 40);
    System.out.println("Rectangle Area is :=> "+r.getArea());
    System.out.println(b.getBook());


  }
}

