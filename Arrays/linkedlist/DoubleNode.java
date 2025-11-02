package linkedlist;

public class DoubleNode {
    public int data;
    public DoubleNode prev;
    public DoubleNode next;

    DoubleNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
