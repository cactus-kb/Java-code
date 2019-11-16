package package1115;

class Node {
    public int data;
    public Node next;

    public Node() {

    }

    public Node(int data) {
        this.data = data;
    }
}

public class LinkedList {
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
        Node node = new Node(data);
        if (index < 0 || index > size()) {
            return false;
        }
        if (index == 0) {
            addFirst(data);
            return true;
        }
        Node cur = getIndex(index);
        node.next = cur.next;
        cur.next = node;
        return true;
    }
    private Node getIndex(int index) {
        int count = 0;
        Node cur = this.head;
        while (count < index - 1) {
            cur = cur.next;
            count++;
        }
        return cur;
    }

    //查找单链表中是否包含关键字key
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
        }
        Node prev = getkey(key);
        if (prev == null) {
            return;
        }
        Node delete = prev.next;
        prev.next = delete.next;
    }
    private Node getkey(int key) {
        Node prev = this.head;
        while (prev.next != null) {
            if (prev.next.data == key) {
                return prev;
            }
        }
        return null;
    }

    //删除所有值为Key的节点
    public void removeAllkey(int key) {
      if (this.head.data == key) {
          this.head = this.head.next;
      }
      Node prev = this.head;
      Node cur = this.head.next;
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

    //得到链表长度
    public int size() {
        int count = 0;
        Node cur = this.head;
        while (cur != null) {
            cur = cur.next;
            count++;
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
}

