package package1110;

public class MYquene2 {
    //基于数组
    private int[] data = new int[100];
    // [head tail)
    private int head = 0;//队首元素的下标
    private int tail = 0;//队尾元素的下标
    private int size = 0;

    //入队列;如果插入成功，返回true，否则返回false
    //如果队列满了，再插入就会失败
    public boolean offer(int x) {
        if (size == data.length) {
            return false;
        }
        //新元素放到tail位置上
        data[tail] = x;
        tail++;
        if (tail == data.length) {
            tail = 0;
        }
        size++;
        return true;
    }

    //出队列
    public Integer poll() {
        if (size == 0) {
            return null;
        }
        Integer ret = data[head];
        head++;
        if (head == data.length) {
            head = 0;
        }
        size--;
        return ret;
    }

    //取队首元素
    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return data[head];
    }

    //判定为空
    public boolean isEmpty() {
        return size == 0;
    }

    //取长度
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        MYquene2 mYquene2 = new MYquene2();
        mYquene2.offer(1);
        mYquene2.offer(2);
        mYquene2.offer(3);
        mYquene2.offer(4);
        while (!mYquene2.isEmpty()) {
            Integer cur = mYquene2.peek();
            System.out.println(cur);
            mYquene2.poll();
        }
    }
}
