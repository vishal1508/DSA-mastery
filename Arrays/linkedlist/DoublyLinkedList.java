package linkedlist;

class DoublyLinkListNode {
  int data;
DoublyLinkListNode prev;
DoublyLinkListNode next;

DoublyLinkListNode(int data) {
    this.data = data;
    this.next = null;
    this.prev = null;
  }
}

class DoublyList {
DoublyLinkListNode head;

  public void insertAtBeginning(int data) {
  DoublyLinkListNode newData = new DoublyLinkListNode(data);
    if (head == null) {
      head = newData;
      return;
    }

    newData.next = head;
    head.prev = newData;
    head = newData;

  }

  public void insertAtEnd(int data) {
  DoublyLinkListNode newData = new DoublyLinkListNode(data);
    if (head == null) {
      head = newData;
      return;
    }
  DoublyLinkListNode temp = head;
    while (temp.next != null) {
      temp = temp.next;
    }
    temp.next = newData;
    newData.prev = temp;

  }

  public void insertAfterDoublyLinkListNoder(int data, int afterDoublyLinkListNode) {
  DoublyLinkListNode temp = head;
    boolean isFound = false;
    while (temp != null) {
      if (afterDoublyLinkListNode == temp.data) {
        isFound = true;
        break;
      }
      temp = temp.next;
    }
    if (!isFound) {
      System.out.printf("\n %d this DoublyLinkListNode is not exist so we cant insert!!!", afterDoublyLinkListNode);
      return;
    }
  DoublyLinkListNode newData = new DoublyLinkListNode(data);
    newData.next = temp.next;
    temp.next = newData;
    newData.prev = temp;
    if (newData.next != null) {
      newData.next.prev = newData;
    }
    return;
  }

  public void displayDubluyLinkedlist() {
  DoublyLinkListNode temp = head;

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
    d.insertAfterDoublyLinkListNoder(25, 20);
    d.displayDubluyLinkedlist();
  }
}
