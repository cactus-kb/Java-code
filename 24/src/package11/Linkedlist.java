package package11;

class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }

    public Node() {

    }
}

public class Linkedlist {
    public Node head;

    public void addFirst(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }

    public void display() {
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

}
