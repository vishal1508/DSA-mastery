import java.util.Scanner;
import java.util.Stack;

public class StackExamples {
  public static void main(String[] args) {
    Stack<String> undoStack = new Stack<>();
    Stack<String> redoStack = new Stack<>();
    Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.println("=== UNDO/REDO STACK MANAGER ===\n" + //
          "1. Add Action\n" + //
          "2. Undo Last Action\n" + //
          "3. Redo Last Action\n" + //
          "4. View Last Action\n" + //
          "5. Search for Action\n" + //
          "6. Show All Actions\n" + //
          "7. Clear All Actions\n" + //
          "8. Exit");
      int choice = sc.nextInt();
      switch (choice) {
        case 1:
          System.out.println("[LOG] Add Action selected -> Enter action to perform");
          sc.nextLine();
          String action = sc.nextLine();
          System.out.print("[LOG] Action added -> Typed " + action);
          System.out.println();
          undoStack.push(action);
          break;
        case 2:
          String undoString = undoStack.pop();
          System.out.print("[LOG] Undo Last Action selected -> Removed: Typed " + undoString + "\n");
          redoStack.push(undoString);
          break;
        case 3:
          String redoString = redoStack.pop();
          System.out.print("[LOG] Redo Last Action selected -> Removed: Typed " + redoString);
          System.out.println();
          undoStack.push(redoString);
          break;
        case 4:
          System.out.println("[LOG] Last Action : " + undoStack.peek());
          break;
        case 5:
          sc.nextLine();
          System.out.println("Enter Action to search : ");
          String searchString = sc.nextLine();
          int undoPosition = undoStack.search(searchString.trim());
          int redoPosition = redoStack.search(searchString.trim());
          if (undoPosition != -1) {
            System.out.println("[LOG] Action found in Undo Stack at position " + undoPosition);
            break;
          } else if (redoPosition != -1) {
            System.out.println("[LOG] Action found in Undo Stack at position " + redoStack);
            break;
          } else {
            System.out.println("[LOG] Action Not found in Undo and Redo Stack ");
            break;
          }
        case 6:
          System.out.println("====== All Actions ======");
          System.out.println("Undo Stack (most recent first):");
          for (int i = 0; i < undoStack.size(); i++) {
            System.out.println((i + 1) + " Typed " + undoStack.get(i));
          }
          if (undoStack.size() == 0) {
            System.out.println("(empty)");
          }
          System.out.println("Redo Stack (most recent first):");
          for (int i = 0; i < redoStack.size(); i++) {
            System.out.println((i + 1) + " Typed " + redoStack.get(i));
          }
          if (redoStack.size() == 0) {
            System.out.println("(empty)");
          }

          break;
        case 7:
          undoStack.clear();
          redoStack.clear();
          break;
        case 8:
          sc.close();
          return;
        default:
          throw new AssertionError();
      }
    }
  }
}