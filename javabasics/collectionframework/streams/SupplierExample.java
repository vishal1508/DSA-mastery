package collectionframework.streams;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<String> s = () -> "Welcome to Java!";
        System.out.println(s.get());

        Supplier<Integer> randomInteger = () -> new Random().nextInt(100)+1;
        System.out.println("Random Number : ="+randomInteger.get());

        Supplier<LocalDateTime> currentData = () -> LocalDateTime.now();
        System.out.println("Current Data is := "+currentData.get());

        Supplier<String> otpGenerate = () -> {
            StringBuilder otp = new StringBuilder("");
            for(int i = 1; i <= 6; i++){
                int random = new Random().nextInt(10);
                if(random <= 9 && random >= 0){
                otp.append(random);
                }
            }
            return otp.toString();
        };

        System.out.println("Otp is := "+otpGenerate.get());

        Supplier<String> user = () -> {
            User u = new User("Vishal");
            return "User Object is Created";
        };
        System.out.println(user.get());
    }
}
class User {
    String name;
    User(String name) { this.name = name; }

    public String getName() {
        return name;
    }
}