package linkedlist;

class Node {
  int data;
  Node prev;
  Node next;

  Node(int data) {
    this.data = data;
    this.next = null;
    this.prev = null;
  }
}

class DoublyList {
  Node head;

  public void insertAtBeginning(int data) {
    Node newData = new Node(data);
    if (head == null) {
      head = newData;
      return;
    }

    newData.next = head;
    head.prev = newData;
    head = newData;

  }

  public void insertAtEnd(int data) {
    Node newData = new Node(data);
    if (head == null) {
      head = newData;
      return;
    }
    Node temp = head;
    while (temp.next != null) {
      temp = temp.next;
    }
    temp.next = newData;
    newData.prev = temp;

  }

  public void insertAfterNoder(int data, int afterNode) {
    Node temp = head;
    boolean isFound = false;
    while (temp != null) {
      if (afterNode == temp.data) {
        isFound = true;
        break;
      }
      temp = temp.next;
    }
    if (!isFound) {
      System.out.printf("\n %d this node is not exist so we cant insert!!!", afterNode);
      return;
    }
    Node newData = new Node(data);
    newData.next = temp.next;
    temp.next = newData;
    newData.prev = temp;
    if (newData.next != null) {
      newData.next.prev = newData;
    }
    return;
  }

  public void displayDubluyLinkedlist() {
    Node temp = head;

    while (temp != null) {
      System.out.printf("%d ->", temp.data);
      temp = temp.next;
    }
  }
}

public class DoublyLinkedList {
  public static void main(String[] args) {
    DoublyList d = new DoublyList();
    // d.insertAtBeginning(10);
    // d.insertAtBeginning(20);
    // d.insertAtBeginning(30);
    d.insertAtEnd(20);
    d.insertAtEnd(30);
    d.insertAtBeginning(10);
    d.insertAfterNoder(25, 20);
    d.displayDubluyLinkedlist();
  }
}
