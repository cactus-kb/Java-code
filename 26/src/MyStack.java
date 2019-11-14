public class MyStack {
    public int[] arr;
    public int top;

    public MyStack() {
        this.arr = new int[10];
    }

    //入栈
    public void push(int data) {
//        for (top = 0; top < arr.length; top++) {
//            arr[top] = data;
//        }
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
//        for (top = arr.length - 1; top > 0; top--) {
//            arr[top] = data;
//        }
//        return arr[top];

        if (isEmpty()) {
            return -1;//表示栈空的时候
        }
        int num = this.arr[--this.top];
        //this.top--;
        return num;
    }
    public boolean isEmpty() {
        if (this.top == 0) {
            return true;
        }
        return false;
    }

    //取栈顶元素
    public int peek() {
        //return arr[arr.length- 1];

        if (isEmpty()) {
            return -1;//表示栈空的时候
        }
        return this.arr[this.top - 1];
    }

    public int size() {
        return this.top;
    }
}
