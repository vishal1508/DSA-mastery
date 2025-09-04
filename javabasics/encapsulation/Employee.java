package encapsulation;
public class Employee {
  private int salary;
  private int id;
  private String name;

  public void setSalary(int n){
    if( n < 10000){
      System.out.println("Salary Should not be less than 10000");
    }
    this.salary = n;
  }
  public int getSalary(){
    return this.salary;
  }
}
