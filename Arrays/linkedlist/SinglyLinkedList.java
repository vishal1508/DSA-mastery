package linkedlist;


class LinkedList {
  private SingleNode head;

  public void insertSingleNode(int data) {
    SingleNode newSingleNode = new SingleNode(data);

    if (head == null) {
      head = newSingleNode;
      return;
    }
    SingleNode temp = head;
    while (temp.next != null) {
      temp = temp.next;
    }
    temp.next = newSingleNode;
  }

  public void insertBegining(int data) {
    SingleNode newSingleNode = new SingleNode(data); // create a SingleNode

    newSingleNode.next = head; // assign rfrence header to a newSingleNode next this newSingleNode create at beginning

    head = newSingleNode; // here now head pointing to newSingleNode

  }

  public void displayList() {
    SingleNode temp = head;
    if (temp == null) {
      System.out.println("List is empty");
      return;
    }
    while (temp != null) {
      System.out.printf("%d -> ", temp.data);
      temp = temp.next;
    }
    System.out.print("null");
  }

  public void insertAfter(int newData, int targetData) {
    SingleNode temp = head;
    boolean isFound = false;
    while (temp != null) {
      if (temp.data == targetData) {
        SingleNode newSingleNode = new SingleNode(newData);
        newSingleNode.next = temp.next;
        temp.next = newSingleNode;
        isFound = true;
        return;
      }
      temp = temp.next;
    }
    if (!isFound) {
      System.out.printf("%d is not found in linked list", targetData);
    }
  }

  public void deleteLinkedList(int data) {
    if (head == null) {
      System.out.println("List is Empty");
      return;
    }
    if (head.data == data) {
      head = head.next;
      return;
    }
    SingleNode prev = head;
    SingleNode temp = head.next;
    while (temp != null && temp.data != data) {
      prev = temp;
      temp = temp.next;
    }
    if (temp == null) {
      System.out.printf("\n %d not found", data);
      return;
    }

    prev.next = temp.next;
  }
}

public class SinglyLinkedList {
  public static void main(String[] args) {
    LinkedList s = new LinkedList();
    s.insertSingleNode(10);
    // s.insertSingleNode(20);
    // s.insertSingleNode(30);
    // s.insertAfter(25, 0);
    s.displayList();
    s.deleteLinkedList(10);
    s.displayList();
  }
}
