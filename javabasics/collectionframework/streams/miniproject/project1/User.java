package collectionframework.streams.miniproject.project1;

public class User {
    String name;
    int age;
    String email;
    double salary;
    User(String name, int age,String email,double salary){
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.email = email;
    }

    @Override
    public String toString() {
        return "( User : "+this.name+" | Age : "+this.age+" | Salary : "+this.salary+" )\n";
    }
}
