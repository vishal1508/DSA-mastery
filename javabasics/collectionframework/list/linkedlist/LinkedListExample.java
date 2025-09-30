package javabasics.collectionframework.list.linkedlist;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class LinkedListExample {
  public static void main(String[] args) {
    LinkedList<String> l = new LinkedList<String>();
    Scanner sc = new Scanner(System.in);

    while (true) {
      try {

        System.out.println("===== Task Manager =====\n" + //
            "1. Add Task (at end)\n" + //
            "2. Add High Priority Task (at beginning)\n" + //
            // "3. Add Task at specific position\n" + //
            // "4. Remove First Task\n" + //
            // "5. Remove Last Task\n" + //
            // "6. Remove Task by Name\n" + //
            // "7. Remove Task by Index\n" + //
            // "8. View First Task\n" + //
            // "9. View Last Task\n" + //
            // "10. View Task by Index\n" + //
            "11. Show All Tasks\n" + //
            // "12. Update Task by Index\n" + //
            // "13. Search Task (contains)\n" + //
            // "14. Find Task Position\n" + //
            // "15. Clear All Tasks\n" + //
            // "16. Check if Empty\n" + //
            // "17. Show Total Tasks\n" + //
            // "18. Serve Next Task (Queue - poll)\n" + //
            // "19. Undo Last Task (Stack - pop)\n" + //
            // "0. Exit\n" + //
            "");

        System.out.print("Enter choice : ");
        int choice = sc.nextInt();

        switch (choice) {
          case 1:
            sc.nextLine();
            System.out.print("Enter task name : ");
            String atEnd = sc.nextLine();
            l.addLast(atEnd);
            break;
          case 2:
            sc.nextLine();
            System.out.print("Enter task name : ");
            String atFirst = sc.nextLine();
            l.addFirst(atFirst);
            break;
          case 11:
            System.out.println("All Task :");
            System.out.println(l);
            break;

          default:
            System.out.println("Invalid Input!!");
        }
      } catch (InputMismatchException e) {
        System.out.println(e.getMessage());
        main(args);
      }
    }
  }
}
