package linkedlist.singlyPracticeQuestion;

import linkedlist.SingleNode;

import java.util.Scanner;

public class SinglyListPracticeQuestion {
    public static void main(String[] args) {
        SignlyLinkedList s = new SignlyLinkedList();
        while (true) {
            System.out.println("1.Insert At Beginning\n2.insert At End" +
                    "\n3.Delete Data from Linked List" +
                    "\n4.Insert After" +
                    "\n5.Delete SingleNode using Index" +
                    "\n6.Display Link List" +
                    "\n7.Count SingleNodes" +
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
                    System.out.println("Enter a Numeric positive index to delete that SingleNode");
                    int deleteByIndex = sc.nextInt();
                    s.deleteSingleNodeByIndex(deleteByIndex);
                    break;
                case 6:
                    System.out.println("Hello");
                    s.displayLinkedList();
                    break;
                case 7:
                    s.countSingleNode();
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

class SignlyLinkedList {
    SingleNode head;

    public void insertAtFirst(int data) {
        SingleNode newSingleNode = new SingleNode(data);
        newSingleNode.next = head;
        head = newSingleNode;
    }

    public void insertAtEnd(int data) {
        SingleNode newSingleNode = new SingleNode(data);
        if (head == null) {
            head = newSingleNode;
            return;
        }
        SingleNode currentSingleNode = head;

        while (currentSingleNode != null && currentSingleNode.next != null) {
            currentSingleNode = currentSingleNode.next;
        }
        currentSingleNode.next = newSingleNode;
    }

    public void deleteByValue(int data) {
        if (head == null) {
            System.out.println("SingleNode not exist to delete");
            return;
        }
        SingleNode currentSingleNode = head;
        while (currentSingleNode.next != null && currentSingleNode.next.data != data) {
            currentSingleNode = currentSingleNode.next;

        }
        if (currentSingleNode.next == null) {
            return;
        }
        currentSingleNode.next = currentSingleNode.next.next;
    }

    public void insertAfter(int key, int data) {
        SingleNode newSingleNode = new SingleNode(data);
        if (head == null) {
            head = newSingleNode;
            return;
        }
        SingleNode currentSingleNode = head;
        while (currentSingleNode.next != null && currentSingleNode.data != key) {
            currentSingleNode = currentSingleNode.next;
        }
        if (currentSingleNode == null) {
            System.out.println("Link List is Empty");
            return;
        }
        System.out.println(currentSingleNode.data);
        newSingleNode.next = currentSingleNode.next;
        currentSingleNode.next = newSingleNode;
    }

    public void deleteSingleNodeByIndex(int index) {
        if (head == null) {
            System.out.println("Linked List is Empty");
            return;
        }
        SingleNode currentSingleNode = head;
        int i = 0;
        while (currentSingleNode.next != null && i < index - 1) {
            currentSingleNode = currentSingleNode.next;
            i++;
        }
        System.out.println(currentSingleNode.data);

    }

    public void displayLinkedList() {
        SingleNode current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void countSingleNode() {
        SingleNode currentSingleNode = head;
        int count = 0;
        while (currentSingleNode != null) {
            currentSingleNode = currentSingleNode.next;
            count++;
        }
        System.out.println("Total SingleNode of Linked List is : " + count);
    }

    public void searchElementInList(int data) {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        SingleNode currentSingleNode = head;
        while (currentSingleNode != null && currentSingleNode.data != data) {
            currentSingleNode = currentSingleNode.next;
        }
        if (currentSingleNode == null) {
            System.out.println("Search is not Found");
            return;
        }
        System.out.println("Search is Found :" + currentSingleNode.data);
    }

    public void reverseLinkedList() {
        SingleNode prev = null;
        SingleNode next = null;
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
//        SingleNode current = head;
//        while (current != null) {
//            next = current.next;
//            current.next = prev;
//            prev = current;
//            current = next;
//        }
        head = recursiveReverseLinkeList(head,prev,next);

    }
    public SingleNode recursiveReverseLinkeList(SingleNode currentNode,SingleNode prev, SingleNode next){
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
