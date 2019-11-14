package package1113;

public class circleQuene {
    public int[] arr;
    public int front;
    public int rear;

    public circleQuene() {
        this.arr = new int[10];
        this.front = 0;
        this.rear = 0;
    }

    public boolean enter(int data) {
        if (isFull()) {
            return false;
        }
        this.arr[this.rear] = data;
        this.rear = (this.rear + 1) % this.arr.length;
        return true;
    }
    public boolean isFull() {
        if ((this.rear + 1) % this.arr.length == this.front) {
            return true;
        }
        return false;
    }

    public boolean out() {
        if (isEmpty()) {
            return false;
        }
        this.front = (this.front + 1) % this.arr.length;
        return true;
    }
    public boolean isEmpty() {
        if (this.front == this.rear) {
            return true;
        }
        return false;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return this.arr[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        int index = 0;
        if (this.rear == 0) {
            index = this.arr.length - 1;
        } else {
            index = this.rear - 1;
        }
        return this.arr[index];
    }
}


