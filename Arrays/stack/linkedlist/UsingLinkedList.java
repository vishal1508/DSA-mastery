package stack.linkedlist;

import java.util.Scanner;

public class UsingLinkedList {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Stack top = null;
    while (true) {
      System.out.println(
          "1. Enter a Data in Stack\n2. Enter a data to remove element from stack\n3. Display Linked List\n4. Exit Menu");
      System.out.print("Enter a choice := ");
      int choice = sc.nextInt();
      switch (choice) {
        case 1:
          System.out.print("Enter Data for Linked List := ");
          int insertData = sc.nextInt();
          top = pushElementLinkedList(top, insertData);
          break;
        case 2:
          top = popElementLinkedList(top);
          break;
        case 3:
          displayLinkedList(top);
          break;
        case 4:
          sc.close();
          return;
        default:
          throw new AssertionError();
      }

    }
  }

  public static Stack pushElementLinkedList(Stack top, int data) {
    Stack newNode = new Stack(data);
    newNode.next = top;
    top = newNode;
    return top;
  }

  public static Stack popElementLinkedList(Stack top) {
    if (top == null) {
      System.out.println("Stack is Empty");
      return top;
    }
    System.out.println(top.data + " is Remove From Stack Successfully");
    top = top.next;
    return top;
  }

  public static void displayLinkedList(Stack top) {
    if (top == null) {
      System.out.println("Linked List is Empty");
      return;
    }
    System.out.println("\n");
    while (top != null) {
      if (top.next == null) {
        System.out.print("[" + top.data + "|" + top.next + "] ");
      } else {
        System.out.print("[" + top.data + "|" + top.next + "] -> ");
      }
      top = top.next;
    }
    System.out.println("\n");
  }
}

class Stack {
  int data;
  Stack next;

  public Stack(int data) {
    this.data = data;
    this.next = null;
  }

}
