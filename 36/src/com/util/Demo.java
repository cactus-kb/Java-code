package com.util;

import java.util.Arrays;

public class Demo {
    public int[] elem;
    public int usedSize;

    public Demo() {
        this.elem = new int[20];
        this.usedSize = 0;
    }

    public void adjustDown(int root, int len) {
        int parent = root;
        int child = 2 * parent + 1;
        while (child < len) {
            if (child + 1 < len && elem[child] < elem[child + 1]) {
                child = child + 1;
            }
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

    public void createHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            this.elem[i] = array[i];
            this.usedSize++;
        }
        for (int i = (this.usedSize-1-1)/2; i >= 0; i--) {
            adjustDown(i,this.usedSize);
        }
    }
    public void adjustUp(int child) {
        int parent = (child-1)/2;
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
    public boolean isFull(){
        return this.usedSize == this.elem.length;
    }
    public void pushHeap(int val) {
        if(isFull()) {
            this.elem = Arrays.copyOf(this.elem,this.elem.length*2);
        }
        this.elem[this.usedSize] = val;
        this.usedSize++;//11
        adjustUp(usedSize-1);
    }

    public boolean isEmpty() {
        return this.usedSize == 0;
    }

    public void popHeap() {
        //0、堆为空的时候
        if(isEmpty()) {
            return;
        }
        //1、根顶元素和最后一个元素进行交换
        int tmp = this.elem[0];
        this.elem[0] = this.elem[this.usedSize-1];
        this.elem[this.usedSize-1] = tmp;
        this.usedSize--;
        //2、向下调整，只需要调整0号下标这棵树
        adjustDown(0,this.usedSize);
    }

    public int getPop() {
        if(isEmpty()) {
            return -1;
        }
        return this.elem[0];
    }

    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] +" ");
        }
        System.out.println();
    }

    public void heapSort() {
        int end = this.usedSize - 1;
        while (end > 0) {
            int t = this.elem[0];
            this.elem[0] = this.elem[end];
            this.elem[end] = t;
            adjustDown(0,end);
            end--;
        }
    }
}
