package javabasics.collectionframework.list.linkedlist;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class LinkedListExample {
  static int choice;
  static String taskName;
  static int position;

  public static void main(String[] args) {
    LinkedList<String> l = new LinkedList<String>();
    Scanner sc = new Scanner(System.in);

    while (true) {
      try {

        System.out.println("===== Task Manager =====\n" + //
            "1. Add Task (at end)\n" + //
            "2. Add High Priority Task (at beginning)\n" + //
            "3. Add Task at specific position\n" + //
            "4. Remove First Task\n" + //
            "5. Remove Last Task\n" + //
            "6. Remove Task by Name\n" + //
            "7. Remove Task by Index\n" + //
            "8. View First Task\n" + //
            "9. View Last Task\n" + //
            "10. View Task by Index\n" + //
            "11. Show All Tasks\n" + //
            "12. Update Task by Index\n" + //
            "13. Search Task (contains)\n" + //
            "14. Find Task Position\n" + //
            "15. Clear All Tasks\n" + //
            "16. Check if Empty\n" + //
            "17. Show Total Tasks\n" + //
            "18. Serve Next Task (Queue - poll)\n" + //
            "19. Undo Last Task (Stack - pop)\n" + //
            "0. Exit\n" + //
            "");

        System.out.print("Enter choice : ");
        choice = sc.nextInt();

        switch (choice) {
          case 0:
            sc.close();
            return;
          case 1:
            sc.nextLine();
            System.out.print("Enter task name : ");
            taskName = sc.nextLine();
            l.addLast(taskName);
            System.out.println("Task added at end!\n");
            break;
          case 2:
            sc.nextLine();
            System.out.print("Enter task name : ");
            taskName = sc.nextLine();
            l.addFirst(taskName);
            System.out.println("Task added at beginning!\n");
            break;
          case 3:
            System.out.print("Enter position (0-based index): ");
            position = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter task name : ");
            taskName = sc.nextLine();
            l.add(position, taskName);
            System.out.println("Task added at position " + position);
            break;
          case 4:
            l.remove(0);
            System.out.println("First Task has been Removed Successfully");
            break;
          case 5:
            l.remove(l.size() - 1);
            System.out.println("Last Task has been Removed Successfully");
            break;
          case 6:
            sc.nextLine();
            System.out.print("Enter task name : ");
            taskName = sc.nextLine();
            l.remove(taskName);
            break;
          case 7:
            System.out.print("Enter position (0-based index): ");
            position = sc.nextInt();
            l.remove(position);
            break;
          case 8:
            System.out.println("First Task : " + l.get(0));
            break;
          case 9:
            System.out.println("Last Task : " + l.get(l.size() - 1));
            break;
          case 10:
            System.out.print("Enter index to view task : ");
            position = sc.nextInt();
            System.out.println("Task at index " + position + " : " + l.get(position));
            break;
          case 11:
            System.out.println("All Task :");
            System.out.println(l);
            break;
          case 12:
            System.out.print("Enter index to update : ");
            position = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter new task : ");
            taskName = sc.nextLine();

            l.set(position, taskName);
            break;
          case 13:
            sc.nextLine();
            System.out.print("Enter task name to search : ");
            taskName = sc.nextLine();
            boolean isFound = l.contains(taskName);
            if (isFound) {
              System.out.println("Task " + taskName + " found in the list!");
              break;
            }
            System.out.println("Task " + taskName + " Not found in the list!");
            break;
          case 14:
            sc.nextLine();
            System.out.print("Enter task name to find : ");
            taskName = sc.nextLine();
            for (int i = 0; i < l.size(); i++) {
              if (taskName.equals(l.get(i))) {
                System.out.println("Task " + taskName + " is at position : " + i);
                break;
              }
            }
            break;
          case 15:
            l.removeAll(l);
            if (l.size() == 0) {
              System.out.println("Tasks has been Remove Successfully");
              break;
            }
            System.out.println("Tasks Failed to Clear ");
            break;
          case 16:
            if (l.isEmpty()) {
              System.out.println("Task is Empty");
              break;
            }
            System.out.println("Task is Not Empty");
            break;
          case 17:
            System.out.println("Total Task is : " + l.size());
            break;
          case 18:
            System.out.println("Serving next task :  " + l.poll());
            break;
          case 19:
            System.out.println("Undo Last Task :  " + l.pollLast());
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
