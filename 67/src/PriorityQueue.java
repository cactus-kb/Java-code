public class PriorityQueue {
    private int[] array = new int[10];
    private int size = 0;

    private void adjustUP() {
        int index = size;
        while (index != 0) {
            int parent = (index - 1) / 2;
            if (array[index] <= array[parent]) {
                break;
            }
            swap(index, parent);
            index = parent;
        }
    }

    private void swap(int index, int parent) {
        int t = array[index];
        array[index] = array[parent];
        array[parent] = t;
    }

    public void put(int val) {
        if (size == array.length) {
            throw new RuntimeException("满了");
        }
        array[size] = val;
        adjustUP();
        size++;
    }

    public int take() {
        if (size == 0) {
            throw new RuntimeException("空的");
        }
        int val = array[0];
        array[0] = array[size - 1];
        size--;
        adjustDown();
        return val;
    }

    private void adjustDown() {
        int index = 0;
        while (2 * index + 1 < size) {
            int max = 2 * index + 1;
            if (max + 1 < size && array[max + 1] > array[max]) {
                max++;
            }
            if (array[index] >= array[max]) {
                break;
            }
            swap(index, max);
            index = max;
        }
    }
}
