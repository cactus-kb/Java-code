class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }
}

public class MyLinked {
    public Node head;
    public Node tail;
    public int usesize = 0;
    //入队
    public void offer(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
            this.tail = tail;
        } else {
            this.tail.next = node;
            this.tail = this.tail.next;
        }
        usesize++;
    }

    //出队
    public int pol() {
        if (this.head == null) {
            return -1;
        }
        Node oldhead = this.head;
        this.head = this.head.next;
        if (this.head == null) {
            tail = null;
        }
        usesize--;
        return head.data;
    }

    //取队头元素
    public int peek() {
        if (this.head == null) {
            return -1;
        }
        return this.head.data;
    }
}
