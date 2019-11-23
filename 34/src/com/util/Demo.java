package com.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        int[] arr = new int[] {1,4,3,7,9,6,0,3,4,5,3};
        System.out.println(Arrays.toString(arr));
        bubblesort(arr);;
        System.out.println(Arrays.toString(arr));
    }
    public static void bubblesort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }


    public static void mergesort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergesort(arr, low, mid);
            mergesort(arr, mid + 1, high);
            merget(arr,low,mid,high);
        }
    }

    public static void merget(int[] arr, int low, int mid, int high) {
        int[] tmp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int index = 0;
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                tmp[index] = arr[i];
                i++;
            } else {
                tmp[index] = arr[j];
                j++;
            }
            index++;
        }
        while (j <= high) {
            tmp[index] =arr[j];
            j++;
            index++;
        }
        while (i <= mid) {
            tmp[index] = arr[i];
            i++;
            index++;
        }
        for (int k = 0; k < tmp.length; k++) {
            arr[k + low] = tmp[k];
        }
    }

    public static void main1(String[] args) {
        List<String> courses = new ArrayList<>();
        courses.add("C");
        courses.add("Java");
        courses.add("java web");
        courses.add("java SE");
        System.out.println(courses);
        System.out.println("==========");
        System.out.println(courses.get(0));
        System.out.println(courses);
        courses.set(0,"php");
        System.out.println(courses);
        System.out.println("==========");
        List<String> subCourses = courses.subList(1,3);
        System.out.println(subCourses);
        System.out.println("*****************1");
        List<String> course2 = new ArrayList<>(courses);
        System.out.println(course2);
        System.out.println("**************2");
        List<String> courses3 = new ArrayList<>(courses);
        System.out.println(courses3);
    }
}
