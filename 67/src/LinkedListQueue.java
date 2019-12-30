public class LinkedListQueue {
    private static class Node {
        private int val;
        private Node next = null;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node head = null;
    private Node last = null;

    public void put(int val) {
        if (head == null) {
            head = new Node(val);
            last = head;
        } else {
            last.next = new Node(val);
            last = last.next;
        }
    }

    public int take() {
        if (head == null) {
            throw  new RuntimeException("队列是空的");
        }
        int val = head.val;
        head = head.next;
        if (head == null) {
            last = null;
        }
        return val;
    }
}
