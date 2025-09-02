package encapsulation;
public class Student{
  private String name ;
  private int age;

  public String getStudentName(){
    return this.name;
  }
  public int getAge(){
    return this.age;
  }
  public String setStudentName(String sname){
    this.name = sname;
    return (sname.equals(this.name)?"Student Name Has been Change Successfully":"Failed To Set Student name");
  }
  public String setStudentAge(int sage){
    if(age < 18){
      System.out.println("You are not eligible to admission in colleage")  ;
      return "";
      
    }
     this.age = sage;
    return (sage == this.age?"Student Name Has been Change Successfully":"Failed To Set Student name");
  
  }
}
