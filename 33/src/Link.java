
class Node1 {
    public int data;
    public Node1 next;

    public Node1() {

    }

    public Node1(int data) {
        this.data = data;
    }
}
public class Link {
    public Node1 head;

    public void addFirst(int data) {
        Node1 node = new Node1(data);
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }

    public void addLast(int data) {
        Node1 node = new Node1(data);
        if (this.head == null) {
            this.head = node;
        } else {
            Node1 cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }


    public boolean addIndex(int index, int data) {
        if (index < 0 || index > size()) {
            return false;
        }
        if (index == 0) {
            addFirst(data);
            return true;
        }
        Node1 cur = searchIndex(index);
        Node1 node = new Node1(data);
        node.next = cur.next;
        cur.next = node;
        return true;
    }

    private Node1 searchIndex(int index) {
        int count = 0;
        Node1 cur = this.head;
        while (count < index - 1) {
            cur = cur.next;
            count++;
        }
        return cur;
    }

    public int size() {
        int count = 0;
        Node1 cur = this.head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    public boolean contains(int key) {
        Node1 cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public void remove(int key) {
        if (this.head.data == key) {
            this.head = this.head.next;
            return;
        }
        Node1 prev = searchPrev(key);
        if (prev == null) {
            return;
        }
        Node1 delete = prev.next;
        prev.next = delete.next;
    }
    private Node1 searchPrev(int key) {
        Node1 prev = this.head;
        while (prev.next != null) {
            if (prev.next.data == key) {
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }

    public void removeAll(int key) {
        if (this.head.data == key) {
            this.head = this.head.next;
        }
        Node1 prev = this.head;
        Node1 cur = this.head.next;
        while (cur != null) {
            if (cur.data == key) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
    }

    public void display() {
        Node1 cur = this.head;
        while (cur != null) {
            System.out.println(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void clear() {
        this.head = null;
    }

    public Node1 reverselist() {
        Node1 prev = null;
        Node1 cur = this.head;
        Node1 newHead = null;
        while (cur != null) {
            Node1 curNext = cur.next;
            if (curNext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }

    public Node1 middleNode() {
        int count = 0;
        Node1 cur = this.head;
        int len = size() / 2;
        while (count != len) {
            cur = cur.next;
            count++;
        }
        return cur;
    }

    public Node1 midNode() {
        if (this.head == null) {
            return null;
        }
        if (this.head.next == null) {
            return this.head;
        }
        Node1 fast = this.head;
        Node1 slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public Node1 findtail(int k) {
        if (this.head == null) {
            return null;
        }
        Node1 slow = this.head;
        Node1 fast = this.head;
        int count = 0;
        while (count != k - 1 && k - 1 > 0) {
            if (fast.next != null) {
                fast = fast.next;
                count++;
            } else {
                System.out.println("节点不存在");
                return fast;
            }
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public Node1 mergeTwoList(Node1 l1, Node1 l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        Node1 newHead = null;
        Node1 tail = newHead;
        while (l1 != null && l2 != null) {
            if (l1.data >= l2.data) {
                Node1 l2N = l2.next;
                if (newHead == null) {
                    newHead = l2;
                } else {
                    tail.next = l2;
                }
                tail = l2;
                l2 = l2N;
            } else {
                Node1 l1N = l1.next;
                l1.next = null;
                if (newHead == null) {
                    newHead = l1;
                } else {
                    tail.next = l1;
                }
                tail = l1;
                l1 = l1N;
            }
        }
        if (l1 != null) {
            tail.next = l1;
        }
        if (l2 != null) {
            tail.next = l2;
        }
        return newHead;
    }

    public Node1 parttion(int x) {
        Node1 bs = null;
        Node1 be = null;
        Node1 as = null;
        Node1 ae = null;
        Node1 cur = this.head;
        while (cur != null) {
            Node1 curNext = cur.next;
            if (cur.data < x) {
                if (bs == null) {
                    bs = cur;
                    be = cur;
                } else {
                    be.next = cur;
                    be = be.next;
                }
            } else {
                if (as == null) {
                    as = cur;
                    ae = cur;
                } else {
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur = curNext;
        }
        if (bs == null) {
            return as;
        }
        be.next = as;
        return bs;
    }

    public Node1 deletesame() {
        Node1 newHead = new Node1(-1);
        Node1 cur = this.head;
        Node1 tmp = newHead;
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

    public boolean chkPalindrome() {
        Node1 slow = this.head;
        Node1 fast = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node1 cur = slow;
        Node1 prev = null;
        Node1 newHead = null;
        while (cur != null) {
            Node1 curNext = cur.next;
            cur.next = null;
            if (curNext == null) {
                newHead = cur;
            }
            cur.next = curNext;
            prev = cur;
            newHead = curNext;
            while (this.head != null && newHead != null) {
                if (this.head.data != newHead.data) {
                    return false;
                }
                newHead = newHead.next;
                this.head = this.head.next;
            }
        }
        return true;
    }

    public boolean hasCircle() {
        Node1 fast = this.head;
        Node1 slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}























