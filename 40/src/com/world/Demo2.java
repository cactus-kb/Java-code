package com.world;

public class Demo2 {

    public int[] elem;
    public int usedSize;

    public Demo2() {
        this.elem = new int[20];
        this.usedSize = 0;
    }
//    public void adjustDown(int root, int len) {
//        int parent = root;
//        int child = 2 * parent + 1;
//        while (child < len) {
//            if (child + 1 < len && elem[child] < elem[child + 1]) {
//                child = child + 1;
//            }
//            if (elem[child] > elem[parent]) {
//                int tmp = elem[child];
//                elem[child] = elem[parent];
//                elem[parent] = tmp;
//                parent = child;
//                child = 2 * parent + 1;
//            } else {
//                break;
//            }
//        }
//    }
}
