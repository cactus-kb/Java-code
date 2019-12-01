import java.util.Arrays;

public class Demo {

    public int[] elem;
    public int usedSize;
    public Demo() {
        this.elem = new int[20];

    }
    /*
     * 调整每一棵树的代码
     * */
    //root:每次调整的树的根节点下标
    public void adjustDown(int root,int len) {
        int parent = root;
        int child = 2 * parent + 1;
        while (child < len) {
            //判断是否有右孩子，且谁最大
            if (child + 1 < len && elem[child] < elem[child + 1]) {
                child = child + 1;
            }
            //child肯定是左右孩子的最大值下标
            if (elem[child] > elem[parent]) {
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }
    }

    /*
     * 调整整棵大树的代码
     * */
    public void createHeap(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            this.elem[i] = arr[i];
            this.usedSize++;
        }
        for (int i = (this.usedSize - 1 - 1) / 2; i >= 0; i--) {
            adjustDown(i,this.usedSize);
        }
    }

    public boolean iisFun() {
        return this.usedSize == this.elem.length;
    }

    public void pushHeap(int val) {
        if (iisFun()) {
            this.elem = Arrays.copyOf(this.elem,this.elem.length * 2);
        }
        this.elem[this.usedSize] = val;
        this.usedSize++;
        adjustUp(usedSize - 1);
    }

    public void adjustUp(int child) {
        int parent = (child - 1) / 2;
        while (child > 0) {
            if(this.elem[child] > this.elem[parent]) {
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                child = parent;
                parent = (child-1)/2;
            }else {
                break;
            }
        }
    }

    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.println(this.elem[i] + " ");
            System.out.println();
        }
    }

    public boolean isEmpty() {
        return this.usedSize == 0;
    }

    public void popHeap() {
        if (isEmpty()) {
            return;
        }
        int tmp = this.elem[0];
        this.elem[0] = this.elem[this.usedSize - 1];
        this.elem[this.usedSize - 1] = tmp;
        this.usedSize--;
        adjustDown(0,this.usedSize);
    }

    public int getPop() {
        if (isEmpty()) {
            return -1;
        }
        return this.elem[0];
    }
}
