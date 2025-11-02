package linkedlist;



class DoublyList {
DoubleNode head;

  public void insertAtBeginning(int data) {
  DoubleNode newData = new DoubleNode(data);
    if (head == null) {
      head = newData;
      return;
    }

    newData.next = head;
    head.prev = newData;
    head = newData;

  }

  public void insertAtEnd(int data) {
  DoubleNode newData = new DoubleNode(data);
    if (head == null) {
      head = newData;
      return;
    }
  DoubleNode temp = head;
    while (temp.next != null) {
      temp = temp.next;
    }
    temp.next = newData;
    newData.prev = temp;

  }

  public void insertAfterDoubleNoder(int data, int afterDoubleNode) {
  DoubleNode temp = head;
    boolean isFound = false;
    while (temp != null) {
      if (afterDoubleNode == temp.data) {
        isFound = true;
        break;
      }
      temp = temp.next;
    }
    if (!isFound) {
      System.out.printf("\n %d this DoubleNode is not exist so we cant insert!!!", afterDoubleNode);
      return;
    }
  DoubleNode newData = new DoubleNode(data);
    newData.next = temp.next;
    temp.next = newData;
    newData.prev = temp;
    if (newData.next != null) {
      newData.next.prev = newData;
    }
    return;
  }

  public void displayDubluyLinkedlist() {
  DoubleNode temp = head;

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
    d.insertAfterDoubleNoder(25, 20);
    d.displayDubluyLinkedlist();
  }
}
