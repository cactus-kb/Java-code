public class PriorityQueue {
    int[] arrary = new int[10];
    private int size = 0;

    public void put(int val) {
        if (size == arrary.length) {
            throw new RuntimeException("满了");
        }
        arrary[size] = val;
        adjustUp();
        size++;
    }

    private void adjustUp() {
        int index =size;
        while (index != 0) {
            int parent = (index - 1) / 2;
            if (arrary[index] > arrary[parent]) {
                break;
            }
            swap(index,parent);
            index = parent;
        }
    }

    private void swap(int index, int parent) {
        int t = arrary[index];
        arrary[index] = arrary[parent];
        arrary[parent] = t;
    }

    public int take() {
        if (size == 0) {
            throw new RuntimeException("空的");
        }
        int val = arrary[0];
        arrary[0] = arrary[size - 1];
        size--;
        adjustDown();
        return val;
    }

    private void adjustDown() {
        int index = 0;
        while (2 * index + 1 < size) {
            int max = 2 * index + 1;
            if (max + 1 < size && arrary[max + 1] > arrary[max]) {
                max++;
            }
            if (arrary[index] >= arrary[index]) {
                break;
            }
            swap(index, max);
            index = max;
        }
    }
}
