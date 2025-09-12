package linkedlist;

class Node {
  int data;
  Node next;

  Node(int data) {
    this.data = data;
    this.next = null;
  }
}

class SignlyLinkedList {
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
  }
}

public class InsertLinkedList {
  public static void main(String[] args) {
    SignlyLinkedList s = new SignlyLinkedList();
    s.insertNode(10);
    s.insertNode(20);
    s.displayList();
  }
}
