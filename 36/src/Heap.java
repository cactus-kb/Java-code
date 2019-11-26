public class Heap {

    public void adjustDown(int[] array, int root) {
        //root每次调整的树的根节点下标
        int parent = root;
        int child = 2 * parent + 1;
        while (child < array.length) {
            if (child + 1 < array.length && array[child] < array[child + 1]) {
                child = child + 1;
            }
            if (array[child] > array[parent]) {
                int tmp = array[parent];
                array[parent] = array[child];
                array[child] = tmp;
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }
    }

    public void creatHeap(int[] array) {
        for (int i = (array.length - 1 - 1) / 2; i >= 0; i--){
            adjustDown(array,i);
        }
    }

    public void pushHeap(int val) {

    }

    public void adjustUp(int child) {
        int parent = (child - 1) / 2;
        while (child > 0) {
            if (child > parent) {
                int tmp = parent;
                parent = child;
                child = tmp;
                parent = child;
                parent = (child - 1) / 2;
            } else {
                break;
            }
        }
    }


}

