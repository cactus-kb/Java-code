package com.world;

public class TestHeap {
    /*
    * 调整每一棵树的代码
    * */
    //root:每次调整的树的根节点下标
    public void adjustDown(int[] arr, int root) {
        int parent = root;
        int child = 2 * parent + 1;
        while (child < arr.length) {
            //判断是否有右孩子，且谁最大
            if (child + 1 < arr.length && arr[child] < arr[child + 1]) {
                child = child + 1;
            }
            //child肯定是左右孩子的最大值下标
            if (arr[child] > arr[parent]) {
                int tmp = arr[child];
                arr[child] = arr[parent];
                arr[parent] = tmp;
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
        for (int i = (arr.length - 1 - 1) / 2; i >= 0; i--) {
            adjustDown(arr,i);
        }
    }
}
