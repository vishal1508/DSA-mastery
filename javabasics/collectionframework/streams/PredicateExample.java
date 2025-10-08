package collectionframework.streams;

import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        Predicate<Integer> isEven = a -> a % 2 == 0;
        Predicate<Integer> isGreater = a -> a > 100;
        Predicate<String> isStartsWithA = a -> a.toLowerCase().startsWith("a");
        Predicate<String> isStringEmpty = a -> a.isEmpty();
        Predicate<String> isStringLengthGreaterThan5 = a -> a.length() > 5;
        Predicate<Integer> isNumberPositive = a -> a >= 0;
        Predicate<Character> isVowel = a -> a.equals('a') || a.equals('e') || a.equals('i') || a.equals('o') || a.equals('u');

        System.out.println(isEven.test(10)); // check is Eeven  if is even then true
        System.out.println(isGreater.test(101)); // check number is Greater than 100
        System.out.println(isStartsWithA.test("Ashish"));
        System.out.println(isStringEmpty.test(""));
        System.out.println(isStringLengthGreaterThan5.test("Vishal"));
        System.out.println(isVowel.test('a'));


    }
}
