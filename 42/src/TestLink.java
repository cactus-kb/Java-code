import java.util.HashMap;
import java.util.Map;

public class TestLink<T> {
    static class Node<T> {
        public T data;
        public Node<T> next;

        public Node() {

        }
        public Node(T data) {
            this.data = data;
        }
    }

    public Node<T> head;
    public TestLink() {

    }

    public void addLast(T data) {
        Node<T> node = new Node<>(data);
        if (this.head == null) {
            this.head = node;
        } else {
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    public void display() {
        Node cur = this.head;
        while (cur != null) {
            System.out.println(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void display2(Node newHead) {
        Node cur = newHead;
        while (cur != null) {
            System.out.println(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

}















