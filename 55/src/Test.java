import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Test {
    private int[] array = new int[10];
    private volatile int size = 0;   // 有效元素个数
    private int front = 0;
    private int rear = 0;

    public void put(int val) {
        if (size == array.length) {
            throw new RuntimeException("满了");
        }

        array[rear] = val;
        rear = (rear + 1) % array.length;
        synchronized (this) {
            size++;
        }
    }

    public int take() {
        if (size == 0) {
            throw new RuntimeException("空了");
        }

        int val = array[front];
        front = (front + 1) % array.length;
        synchronized (this) {
            size--;
        }
        return val;
    }

    public int getSize() {
        return size;
    }

    private static ArrayQueue queue = new ArrayQueue();

    private static class Producer extends Thread {
        Producer() {
            super("生产者");
        }

        PrintWriter printWriter;
        {
            try {
                printWriter = new PrintWriter("生产了.txt", "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            Random random = new Random(20191216);
            for (int i = 0; i < 1000; i++) {
                int val = random.nextInt(100);
                printWriter.println(val);
                do {
                    try {
                        queue.put(val);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                } while (true);
            }
            printWriter.close();
        }
    }

    private static class Customer extends Thread {
        PrintWriter printWriter;
        Customer() {
            super("消费者");
        }

        {
            try {
                printWriter = new PrintWriter("消费了.txt", "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                do {
                    int val = 0;
                    try {
                        val = queue.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    printWriter.println(val);
                    break;
                } while (true);
            }
            printWriter.close();
        }
    }

    public static void main(String[] args) {
        Producer producer = new Producer();
        producer.start();
        Customer customer = new Customer();
        customer.start();
    }


    public static void heapSort(int[] arr) {
        //创建堆
        createHeap(arr);
        //循环取出堆顶的最大值，放到最后面
        for (int i = 0; i < arr.length; i++) {
            //待排序区间：[0,arr.length - i)
            //已排序区间：[arr.length - i, arr.length)
            swap(arr,0,arr.length - i - 1);
            //第一个参数是数组
            //第二个参数是数组中的有效元素的个数
            //第三个参数是从哪个位置进行向下调整
            shiftDown(arr,arr.length - i - 1,0);
        }
    }

    private static void createHeap(int[] arr) {
        //从最后一个非叶子节点，开始出发，从后往前向下调整
        for (int i = (arr.length - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(arr,arr.length,i);
        }
    }

    private static void shiftDown(int[] arr,int size,int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while (child < size) {
            if (child + 1 < size && arr[child + 1] > arr[child]) {
                child = child + 1;
            }
            //以上保证了child指向左右子树的最大值
            if (arr[child] > arr[parent]) {
                //建立大堆
                swap(arr,child,parent);
            } else {
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }


    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i - 1; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    private static void quickSort(int[] arr) {
        ////参数的含义表示针对数组中的那段区间进行快速排序
        quickSortHelper(arr,0,arr.length - 1);
    }

    private static void quickSortHelper(int[] arr, int left,int right) {
        if (left >= right) {
            //只有一个元素或者没有元素
            return;
        }

        //这个方法就是进行区间整理的方法
        //选取基准值，并且把小于基准值的放到左侧，大于基准值的放到右侧
        //返回值[left, right]最终整理完毕后，基准值的下标
        int index = parttition(arr,left,right);
        quickSortHelper(arr,left,index - 1);
        quickSortHelper(arr,index,right);
    }

    private static int parttition(int[] arr,int left,int right) {
        int baseIndex = right;
        int baseValue = arr[baseIndex];
        while (left < right) {
            while (left < right && arr[left] <= baseValue) {
                left++;
            }
            //循环结束之后，left指向的位置，就是从左往右第一个比基准值大的元素
            while (left < right && arr[right] >= baseValue) {
                right--;
            }
            //循环结束之后，right指向的位置就是从右往左第一个比基准值小的元素

            //交换left和right位置的元素
            swap(arr,left,right);
        }
        swap(arr,left,baseIndex);
        return left;
    }

    private static void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

}

