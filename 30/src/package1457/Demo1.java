package package1457;


class Node {
    public int data;
    public Node next;

    public  Node() {

    }

    public Node(int data) {
        this.data = data;
    }
}
public class Demo1 {
    public Node head;


    //头插法
    public void addFirst(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }

    //尾插法
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

    //任意位置插入，第一个数据节点为0号下标
    public boolean addIndex(int index, int data) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("index不合法");
        }
        if (index == 0) {
            addFirst(data);
            return true;
        }
        Node cur = searchIndex(index);
        Node node = new Node(data);
        node.next = cur.next;
        cur.next = node;
        return true;
    }

    private Node searchIndex(int index) {
        int count = 0;
        Node cur = this.head;
        while (count < index - 1) {
            cur = cur.next;
            count++;
        }
        return cur;
    }

    //查找是否包含关键字key是否在单链表中
    public boolean contains(int key) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        if (this.head.data == key) {
            this.head = this.head.next;
            return;
        }
        Node prev = searchPrev(key);
        if (prev == null) {
            return;
        }
        Node delete = prev.next;
        prev.next = delete.next;
    }

    private Node searchPrev(int key) {
        Node prev = this.head;
        while (prev.next != null) {
            if (prev.next.data == key) {
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }

    //删除所有值为key的节点
    public void removeAllkey(int key) {
        if (this.head.data == key) {
            this.head = this.head.next;
        }
        Node prev = this.head;//要删除节点的前驱
        Node cur = this.head.next;//要删除的节点
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

    //得到链表的长度
    public int size() {
        int count = 0;
        Node cur = this.head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    public void display() {
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void clear() {
        this.head = null;
    }


    //链表的回文结构。
    public boolean chkPalindrome() {
        Node slow = this.head;
        Node fast = this.head;
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

    //在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
    public Node deleteDuplication() {
        Node newHead = new Node(-1);
        Node cur = this.head;
        Node tmp = newHead;
        while (cur != null) {
            //找到相同的节点
            if (cur.next != null && cur.data == cur.next.data) {
                while (cur.next != null && cur.data == cur.next.data) {
                    cur = cur.next;
                }
                cur = cur.next;
                tmp.next = cur;
            } else {
                //没有找到相同的节点
                tmp.next = cur;
                tmp = tmp.next;
                cur = cur.next;
            }
        }
        return newHead.next;
    }

    //编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前 。
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
        beforeEnd.next = afterStart;
        return beforeStart;
    }

    //将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

    public Node mergeTwoLists(Node l1, Node l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        Node newHead = null;
        Node tail = newHead;
        while (l1 != null && l2 != null) {
            if (l1.data >= l2.data) {
                Node l2N = l2.next;
                l2.next = null;
                if (newHead == null) {
                    newHead = l2;
                } else {
                    tail.next = l2;
                }
                tail = l2;
                l2 = l2N;
            } else {
                Node l1N = l1.next;
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
    //输入一个链表，输出该链表中倒数第k个结点。
    public Node findTail(int k) {
        if (this.head == null) {
            throw new NullPointerException("链表不存在");
        }
        Node slow = this.head;
        Node fast = this.head;
        int count = 0;
        while (count != k -1 && k - 1 > 0) {
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
}



