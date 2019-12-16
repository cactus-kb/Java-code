public class ArrayQueue {
    private int[] arr = new int[10];
    private int size = 0;
    private int front = 0;
    private int rear = 0;

    public void push(int val) {
        if (size == arr.length) {
            throw new RuntimeException("已满");
        }
        arr[rear++] = val;
        if (rear == arr.length) {
            rear = 0;
        }
        size++;
    }


}
