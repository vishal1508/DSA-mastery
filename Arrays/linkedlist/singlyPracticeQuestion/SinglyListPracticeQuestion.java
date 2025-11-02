package linkedlist.singlyPracticeQuestion;

import java.util.Scanner;

public class SinglyListPracticeQuestion {
    public static void main(String[] args) {
        SignlyLinkedList s = new SignlyLinkedList();
        while (true) {
            System.out.println("1.Insert At Beginning\n2.insert At End" +
                    "\n3.Delete Data from Linked List" +
                    "\n4.Insert After" +
                    "\n5.Delete SinglyLinkListNode using Index" +
                    "\n6.Display Link List" +
                    "\n7.Count SinglyLinkListNodes" +
                    "\n8.Search Element" +
                    "\n9.Reverse Linked List"
            );
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter a Numeric  positive data");
                    int insertAtFirstData = sc.nextInt();
                    s.insertAtFirst(insertAtFirstData);
                    break;
                case 2:
                    System.out.println("Enter a Numeric positive data");
                    int insertAtEndData = sc.nextInt();
                    s.insertAtEnd(insertAtEndData);
                    break;
                case 3:
                    System.out.println("Enter a Numeric positive data to delete");
                    int deleteData = sc.nextInt();
                    s.deleteByValue(deleteData);
                    break;
                case 4:
                    System.out.println("Enter a Numeric positive key to add after this");
                    int inserAfterKey = sc.nextInt();
                    System.out.println("Enter a Numeric positive data to add after that key");
                    int inserAfterData = sc.nextInt();
                    s.insertAfter(inserAfterKey, inserAfterData);
                    break;
                case 5:
                    System.out.println("Enter a Numeric positive index to delete that SinglyLinkListNode");
                    int deleteByIndex = sc.nextInt();
                    s.deleteSinglyLinkListNodeByIndex(deleteByIndex);
                    break;
                case 6:
                    System.out.println("Hello");
                    s.displayLinkedList();
                    break;
                case 7:
                    s.countSinglyLinkListNode();
                    break;
                case 8:
                    System.out.println("Enter a data(Number) for search element : ");
                    int searchElement = sc.nextInt();
                    s.searchElementInList(searchElement);
                    break;
                case 9:
                    s.reverseLinkedList();
                    break;
            }
        }
    }


}

class SinglyLinkListNode {
    int data;
    SinglyLinkListNode next;

    SinglyLinkListNode(int data) {
        this.data = data;
        this.next = null;
    }

}

class SignlyLinkedList {
    SinglyLinkListNode head;

    public void insertAtFirst(int data) {
        SinglyLinkListNode newSinglyLinkListNode = new SinglyLinkListNode(data);
        newSinglyLinkListNode.next = head;
        head = newSinglyLinkListNode;
    }

    public void insertAtEnd(int data) {
        SinglyLinkListNode newSinglyLinkListNode = new SinglyLinkListNode(data);
        if (head == null) {
            head = newSinglyLinkListNode;
            return;
        }
        SinglyLinkListNode currentSinglyLinkListNode = head;

        while (currentSinglyLinkListNode != null && currentSinglyLinkListNode.next != null) {
            currentSinglyLinkListNode = currentSinglyLinkListNode.next;
        }
        currentSinglyLinkListNode.next = newSinglyLinkListNode;
    }

    public void deleteByValue(int data) {
        if (head == null) {
            System.out.println("SinglyLinkListNode not exist to delete");
            return;
        }
        SinglyLinkListNode currentSinglyLinkListNode = head;
        while (currentSinglyLinkListNode.next != null && currentSinglyLinkListNode.next.data != data) {
            currentSinglyLinkListNode = currentSinglyLinkListNode.next;

        }
        if (currentSinglyLinkListNode.next == null) {
            return;
        }
        currentSinglyLinkListNode.next = currentSinglyLinkListNode.next.next;
    }

    public void insertAfter(int key, int data) {
        SinglyLinkListNode newSinglyLinkListNode = new SinglyLinkListNode(data);
        if (head == null) {
            head = newSinglyLinkListNode;
            return;
        }
        SinglyLinkListNode currentSinglyLinkListNode = head;
        while (currentSinglyLinkListNode.next != null && currentSinglyLinkListNode.data != key) {
            currentSinglyLinkListNode = currentSinglyLinkListNode.next;
        }
        if (currentSinglyLinkListNode == null) {
            System.out.println("Link List is Empty");
            return;
        }
        System.out.println(currentSinglyLinkListNode.data);
        newSinglyLinkListNode.next = currentSinglyLinkListNode.next;
        currentSinglyLinkListNode.next = newSinglyLinkListNode;
    }

    public void deleteSinglyLinkListNodeByIndex(int index) {
        if (head == null) {
            System.out.println("Linked List is Empty");
            return;
        }
        SinglyLinkListNode currentSinglyLinkListNode = head;
        int i = 0;
        while (currentSinglyLinkListNode.next != null && i < index - 1) {
            currentSinglyLinkListNode = currentSinglyLinkListNode.next;
            i++;
        }
        System.out.println(currentSinglyLinkListNode.data);

    }

    public void displayLinkedList() {
        SinglyLinkListNode current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void countSinglyLinkListNode() {
        SinglyLinkListNode currentSinglyLinkListNode = head;
        int count = 0;
        while (currentSinglyLinkListNode != null) {
            currentSinglyLinkListNode = currentSinglyLinkListNode.next;
            count++;
        }
        System.out.println("Total SinglyLinkListNode of Linked List is : " + count);
    }

    public void searchElementInList(int data) {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        SinglyLinkListNode currentSinglyLinkListNode = head;
        while (currentSinglyLinkListNode != null && currentSinglyLinkListNode.data != data) {
            currentSinglyLinkListNode = currentSinglyLinkListNode.next;
        }
        if (currentSinglyLinkListNode == null) {
            System.out.println("Search is not Found");
            return;
        }
        System.out.println("Search is Found :" + currentSinglyLinkListNode.data);
    }

    public void reverseLinkedList() {
        SinglyLinkListNode prev = null;
        SinglyLinkListNode next = null;
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
//        SinglyLinkListNode current = head;
//        while (current != null) {
//            next = current.next;
//            current.next = prev;
//            prev = current;
//            current = next;
//        }
        head = recursiveReverseLinkeList(head,prev,next);

    }
    public SinglyLinkListNode recursiveReverseLinkeList(SinglyLinkListNode currentNode,SinglyLinkListNode prev, SinglyLinkListNode next){
        if(currentNode != null){
            next = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode =next;
            return recursiveReverseLinkeList(currentNode,prev,next);
        }
        return prev;
    }
}
