package package1110;

public class MyStack {
    //使用一个数组来表示栈
    //先不考虑扩容的情况
    private int[] arr = new int[100];
    private int size = 0;

    //入栈
    public void push(int x) {
        arr[size ] = x;
        size++;
    }

    //出栈,返回值是出栈的这个元素的值
    public Integer pop() {
        if (size == 0) {
            return null;
        }
        int ret = arr[size - 1];
        size--;
        return ret;
    }

    //取栈顶元素
    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return arr[size - 1];
    }

    //判定栈为空
    public boolean isEmpty() {
        return size == 0;
    }

    //栈的大小
    public int size() {
        return size;
    }
}
