package collectionframework.streams.miniproject.project1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MiniProject1 {
    public static void main(String[] args) {
        Supplier<List<User>> l = () -> {
        List<User> ul = new ArrayList<>();
            ul.add(new User("Vishal",23,"vishal@gmail.com",23000.00));
            ul.add(new User("Rajesh",22,"rajesh@gmail.com",50200.00));
            ul.add(new User("Ramesh",24,"ramesh@gmail.com",51200.00));
            ul.add(new User("Suresh",21,"suresh@gmail.com",20100.00));
            return ul;
        };

        Predicate<User> isAdult = u -> u.age <= 18;
        Predicate<User> isValidEmail = u -> u.email.contains("@") && u.email.contains(".");
        Predicate<User> isHigherSalary = u -> u.salary <= 50000;

        Function<User, String> converUserNametoUpperCase = u -> u.name.toUpperCase();
        Function<User, Double>  applySalaryHike = u -> u.salary + u.salary * 0.10;
        Function<User, User> printFormat = u -> u;

        Consumer<List<String>> printIvalidUser = u -> {for(String us : u) {
            System.out.println(us);
        }};
        Consumer<String> log =  lo -> System.out.println(lo);
            Consumer<List<User>> printValidUser = u -> {for(User us : u) {
            us.name = converUserNametoUpperCase.apply(us);
            us.salary = applySalaryHike.apply(us);
            System.out.println("✅ Valid User : "+printFormat.apply(us));
        }};
        Consumer<List<User>> returnStudents =  u -> {
            int TotalUsers = u.size() - 1;
            int validUSer = 0;
            int invalidUser = 0;
            log.accept("=== User Validation Started ===\n");
            List<User> validUserList = new ArrayList<>();
            List<String> inValidUserList = new ArrayList<>();
            for(int i = 0; i < u.size(); i++){
                if(isAdult.test(u.get(i))){
                    inValidUserList.add("❌ INVALID USER : "+u.get(i).name+" ( Underage )");
                    invalidUser++;
                }else if(!isValidEmail.test(u.get(i))){
                    inValidUserList.add("❌ INVALID USER : "+u.get(i).name+" ( Invalid Email )");
                    invalidUser++;
                }else if(isHigherSalary.test(u.get(i))){
                    inValidUserList.add("❌ INVALID USER : "+u.get(i).name+" ( Invalid salary is greater than 50000 )");
                    invalidUser++;
                }else {
                    validUserList.add(printFormat.apply(u.get(i)));
                validUSer++;
                }

            }

            printValidUser.accept(validUserList);
            printIvalidUser.accept(inValidUserList);

            log.accept("Total Users :"+(u.size()));
            log.accept("Valid Users :"+validUSer);
            log.accept("Invalid Users :"+invalidUser);
            log.accept("=== Processing Complete ===");
        };


        returnStudents.accept(l.get());




}
}
