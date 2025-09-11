package exception;

import java.util.Scanner;

public class NumberFormatexception {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    try {
      int c = sc.nextInt();
    } catch (java.lang.NumberFormatException e) {
      System.out.println("Format Not Match");
    }
  }
}
