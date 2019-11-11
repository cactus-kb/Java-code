package package1110;

class Node{
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }
}

public class MyQueue {
    //基于链表
    //head对应到队首元素
    private Node head = null;
    //tail对应到队尾元素
    private Node tail = null;
    private int size = 0;

    //入队列
    public void offer(int x) {
        Node newNode = new Node(x);
        //插入到链表的尾部
        //空链表
        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }
        //非空链表
        tail.next = newNode;
        tail = tail.next;
        size++;
        return;
    }

    //出队列,返回值：被出队列的元素的值通过返回值来表示
    public Integer poll() {
        //空队列，无法出队列
        if (head == null) {
            return null;
        }
        //非空队列
        Integer ret = head.val;
        head = head.next;
        if (head == null) {
            //如果当前队列就一个元素，删除这个元素的同时也要修改tail的指向
            tail = null;
        }
        size--;
        return ret;
    }

    //取队首元素
    public Integer peek() {
        if (head == null) {
            return null;
        }
        return head.val;
    }

    //判定队列为空
    public boolean isEmpty() {
        return head == null;
    }

    //取队列中元素个数
    public int size() {
        return size;
    }

    public static void main1(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        myQueue.offer(4);
        while (!myQueue.isEmpty()) {
            int curFront = myQueue.peek();
            System.out.println(curFront);
            myQueue.poll();
        }

    }

}
