
class Node {
    private int node;
     Node next = null;

    public Node(int node) {
        this.node = node;
    }
}

public class LinkedQueue {
    public Node head = null;
    public Node tail = null;
    public void push(int node1) {
        Node node = new Node(node1);
        node.next = head;
        head = node;
    }

}
