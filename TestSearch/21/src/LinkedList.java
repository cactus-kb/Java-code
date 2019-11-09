
class Node {
    public int data;
    public Node next;

    public Node() {

    }

    public Node(int data) {
        this.data = data;
    }
}
class LinkedList {
    Node head = new Node();



    public Node findTail(int k) {
        Node slow = this.head;
        Node fast = this.head;
        if (k <= 0 ) {
            return null;
        }
        while (k - 1 > 0) {
            if (fast.next != null) {
                fast = fast.next;
                k--;
            }
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public Node mergeTwoList(Node headA, Node headB) {
        if (headA == null) {
            return headB;
        }
        if (headB == null) {
            return headA;
        }
        Node newHead = new Node(-1);
        while (headA != null && headB != null) {
            Node cur = newHead.next;
            if (headA.data > headB.data) {
                if (cur == null) {
                    cur = headB;
                    cur = cur.next;
                } else {
                    cur.next = headB;
                    headB = headB.next;
                    cur.next = cur.next.next;
                }
            } else {
                if (cur == null) {
                    cur = headA;
                    headA = headA.next;
                    cur = cur.next;
                } else {
                    cur.next = headA;
                    cur.next = cur.next.next;
                }
            }
        }
        return newHead.next;
    }

}
