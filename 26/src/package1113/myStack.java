package package1113;

public class myStack {
    private int[] arr = new int[10];
    private int top;

    //入栈
    public void push(int data) {
        if (isFull()) {
            return;
        }
        this.arr[top++] = data;
    }

    public boolean isFull() {
        if (this.top == this.arr.length) {
            return true;
        }
        return false;
    }
    //出栈
    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        return this.arr[this.top--];
    }

    public boolean isEmpty() {
        if (this.top == 0) {
            return true;
        }
        return false;
    }
    //取栈顶元素
    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return this.arr[this.top - 1];
    }
}
