package stack.array;

import java.util.Scanner;

public class UsingArray {

  public static void main(String[] args) {
    int top = -1;
    int stack[] = new int[5];
    Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.println("1. push element\n2. pop element from array\n3. Display Stack\n4. Exit Menu");
      int choice = sc.nextInt();
      switch (choice) {
        case 1:
          System.out.println("enter a number want to push");
          int n = sc.nextInt();
          top = pushElement(stack, n, top);

          break;
        case 2:
          top = popElement(stack, top);
          break;

        case 3:
          displayStack(stack, top);

          break;
        case 4:
          sc.close();
          return;
        default:
          throw new AssertionError();
      }
    }

  }

  public static int pushElement(int[] stack, int info, int top) {
    if (top == stack.length - 1) {
      System.out.println("Stack is overflow");
    } else {
      top = top + 1;
      stack[top] = info;
    }
    return top;
  }

  public static int popElement(int[] stack, int top) {
    int x = 0;
    if (top == -1) {
      System.out.println("Stack is Undeflow");
    } else {
      x = stack[top];
      top = top - 1;
      System.out.println(x + " is Remove Susccessfully");
    }
    return top;
  }

  public static void displayStack(int[] stack, int top) {
    System.out.println(stack.length);

    for (int i = 0; i <= top; i++) {
      System.out.println(stack[i]);
    }
  }
}
