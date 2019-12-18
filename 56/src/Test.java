import java.util.Stack;

public class Test {

    //非递归的快速排序
    public static void quickSortByLoop(int[] arr) {
        //1.先创建一个栈,栈里面存的是待处理区间的下标
        Stack<Integer> stack = new Stack<>();
        //2.初始情况下待处理区间就是整个数组
        stack.push(arr.length - 1);
        stack.push(0);
        while (!stack.isEmpty()) {
            //3.取栈顶元素，栈顶元素就是我们要处理的区间
            int left = stack.pop();
            int right = stack.pop();
            if (left >= right) {
                continue;
            }
            //4.对当前待处理区间进行整理
            int index = parttition(arr,left,right);
            //5.接下来要处理的区间再入栈
            //[left,index - 1]
            //[index + 1, right]
            stack.push(index - 1);
            stack.push(left);
            stack.push(right);
            stack.push(index + 1);
        }
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
