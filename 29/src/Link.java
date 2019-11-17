
class Node {
    public int data;
    public Node next;

    public Node() {

    }

    public Node(int data) {
        this.data = data;
    }
}

public class Link {
    public Node head;

    public Node deleteDuplication() {
        Node newHead = new Node(-1);
        Node cur = this.head;
        Node tmp = newHead;
        while (cur != null) {
            if (cur.next != null && cur.data == cur.next.data) {
                while (cur.next != null && cur.data == cur.next.data) {
                    cur = cur.next;
                }
                cur = cur.next;
                tmp.next = cur;
            } else {
                tmp.next = cur;
                tmp = tmp.next;
                cur = cur.next;
            }
        }
        return newHead.next;
    }

    public boolean hasCircle() {
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast != slow) {
                return false;
            }
        }
        return true;
    }

    public boolean chkPalindrome() {
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node cur = slow;
        Node prev = null;
        Node newHead = null;
        while (cur != null) {
            Node curNext = cur.next;
            cur.next = null;
            if (curNext == null) {
                newHead = cur;
            }
            cur.next = curNext;
            prev = cur;
            newHead = curNext;
        }
        while (this.head != null && newHead != null) {
            if (this.head.data != newHead.data) {
                return false;
            }
            this.head = this.head.next;
            newHead = newHead.next;
        }
        return true;
    }
}
