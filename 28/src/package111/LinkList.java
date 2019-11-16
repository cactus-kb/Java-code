package package111;

class Node {
    public int data;
    public Node next;

    public Node() {

    }

    public Node(int data) {
        this.data = data;
    }
}

public class LinkList {
    public Node head;

    public Node reverseList() {
     Node cur = this.head;
     Node newHead = null;
     Node prev = null;
     while (cur != null) {
         Node curNext = cur.next;
         if (curNext == null) {
             newHead = cur;
         }
         cur.next = prev;
         prev = cur;
         cur = curNext;
     }
     return newHead;
    }

    public void addLast(int data) {
        Node node = new Node(data);
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

    public Node middleNode() {
        Node cur = this.head;
        int len = size() / 2;
        int count = 0;
        while (count != len) {
            cur = cur.next;
            count++;
        }
        return cur;
    }

    public int size() {
        int count = 0;
        Node cur = this.head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    public Node midNode() {
        Node slow = this.head;
        Node fast = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public Node findTail(int k) {
        Node fast = this.head;
        Node slow = this.head;
        if (this.head == null) {
            return null;
        }
        int count = 0;
        while (count != k && k - 1 > 0) {
            if (fast.next != null) {
                fast = fast.next;
                count++;
            } else {
                System.out.println("这个节点不存在");
                return fast;
            }
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }


    public Node mergoTwoList(Node headA, Node headB) {
        if (headA == null) {
            return headB;
        }
        if (headB == null) {
            return headA;
        }
        Node newHead = null;
        Node tail = null;
        while (headA != null && headB != null) {
            if (headA.data > headB.data) {
                Node cur = headB.next;
                cur.next = null;
                if (newHead == null) {
                    newHead = headB;
                } else {
                    tail.next = headB;
                }
                tail = headB;
                headB = cur;
            } else {
                Node cur1 = headA.next;
                cur1.next = null;
                if (newHead == null) {
                    newHead = headA;
                } else {
                    tail.next = headA;
                }
                tail = headA;
                headA = cur1;
            }
        }
        if (headA != null) {
            return headB;
        }
        if (headB != null) {
            return headB;
        }
        return newHead;
    }

    public Node partition(int x) {
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;
        Node cur = this.head;
        while (cur != null) {
            Node curNext = cur.next;
            cur.next = null;
            if (cur.data < x) {
                if (beforeStart == null) {
                    beforeStart = cur;
                    beforeEnd = cur;
                } else {
                    beforeEnd.next = cur;
                    beforeEnd = beforeEnd.next;
                }
            } else {
                if (afterStart == null) {
                    afterStart = cur;
                    afterEnd = cur;
                } else {
                    afterEnd.next = cur;
                    afterEnd = afterEnd.next;
                }
            }
            cur = curNext;
        }
        if (beforeStart == null) {
            return afterStart;
        }
        if (afterStart == null) {
            return beforeStart;
        }
        return beforeStart;
    }

    public Node deleteDuplication() {
        Node cur = this.head;
        Node newHead = new Node(-1);
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
}
