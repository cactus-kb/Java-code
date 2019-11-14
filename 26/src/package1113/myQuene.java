package package1113;

class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }
}
public class myQuene {
    public Node head;
    public Node tail;
    public int useSize;

    //入队
    public void offer(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            this.tail = this.tail.next;
        }
        this.useSize++;
    }

    //出队
    public int poll() {
        if (this.head == null) {
            return -1;
        }
        int oldData = this.head.data;
        this.head = this.head.next;
        this.useSize--;
        return oldData;
    }

    //取队首元素
    public int peek() {
        if (this.head == null) {
            return -1;
        }
        return this.head.data;
    }

    public int size() {
        return this.useSize;
    }
}
