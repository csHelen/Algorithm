package com.algorithm.search;

/**
 * @program: algorithm
 * @ClassName BinarySearch
 * @description:
 * @author: 许
 * @create: 2020-04-14 20:54
 * @Version 1.0
 **/

import java.util.ArrayList;

/**
 * 二分查找：必须是  有序数组
 * <p>
 * 问题：如果查找的值有多个的话呢？
 */
public class BinarySearch {

    public static void main(String[] args) {
        int arr[] = {1, 8, 10, 89,89,1000, 1235};
        System.out.println(erfen2(arr, 0, arr.length - 1, 89));
    }

    /**
     * @param finaVal 要查找的值
     */
    public static int erfen(int arr[], int left, int right, int finaVal) {

        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (finaVal > midVal) {
            return erfen(arr, mid + 1, right, finaVal);
        } else if (finaVal < midVal) {
            return erfen(arr, left, mid - 1, finaVal);
        } else {
            return mid;
        }
    }


    /**
     * @param finaVal 要查找的值
     */
    public static ArrayList<Integer> erfen2(int arr[], int left, int right, int finaVal) {

        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (finaVal > midVal) {
            return erfen2(arr, mid + 1, right, finaVal);
        } else if (finaVal < midVal) {
            return erfen2(arr, left, mid - 1, finaVal);
        } else {
            ArrayList<Integer> resIndex = new ArrayList<Integer>();
            //左右扫描
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != finaVal) {
                    break;
                }
                resIndex.add(temp);
                temp -= 1;
            }
            resIndex.add(mid);
            temp = mid +1;
            while (true) {
                if (temp == arr.length || arr[temp] != finaVal) {
                    break;
                }
                resIndex.add(temp);
                temp += 1;
            }
            return resIndex;
        }
    }
}
