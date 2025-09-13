package linkedlist;

class Node {
  int data;
  Node next;

  Node(int data) {
    this.data = data;
    this.next = null;
  }
}

class LinkedList {
  private Node head;

  public void insertNode(int data) {
    Node newNode = new Node(data);

    if (head == null) {
      head = newNode;
      return;
    }
    Node temp = head;
    while (temp.next != null) {
      temp = temp.next;
    }
    temp.next = newNode;
  }

  public void insertBegining(int data) {
    Node newNode = new Node(data); // create a node

    newNode.next = head; // assign rfrence header to a newNode next this newNode create at beginning

    head = newNode; // here now head pointing to newNode

  }

  public void displayList() {
    Node temp = head;
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
    Node temp = head;
    boolean isFound = false;
    while (temp != null) {
      if (temp.data == targetData) {
        Node newNode = new Node(newData);
        newNode.next = temp.next;
        temp.next = newNode;
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
    Node prev = head;
    Node temp = head.next;
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
    s.insertNode(10);
    // s.insertNode(20);
    // s.insertNode(30);
    // s.insertAfter(25, 0);
    s.displayList();
    s.deleteLinkedList(10);
    s.displayList();
  }
}
