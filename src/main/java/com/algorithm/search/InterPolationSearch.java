package com.algorithm.search;

/**
 * @program: algorithm
 * @ClassName InterPolationSearch
 * @description:
 * @author: 许
 * @create: 2020-04-14 21:15
 * @Version 1.0
 **/

/**
 *  插值查找
 *      类似二分，但更适合有序的差值不大的数组
 *              分布比较均匀  采用 插值查找，不均匀采用二分查找
 *      就是寻找中值的计算公式不是 (left+right)/2
 *      比较复杂  int mid = left + (right-left)*(finalVal-arr[left]) / (arr[right]-arr[left])
 *      比如查找 1-100的数组
 *              寻找1  用二分要多次查找
 *           插值查找   int mid =  0 + (99-0)*(1-1) / (100-1)  =  0 + 99*0/99 = 0 直接去找0一次获得
 *                再试一次23
 *                      int mid = 0 + (99-0)*(23 - 1) / (100-1) =  99*22/99 = 22   最多两次
 */
public class InterPolationSearch {

    public static void main(String[] args) {
        int []arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+1;
        }
        System.out.println(chazhi(arr, 0, arr.length - 1, 27));
    }

    public static int chazhi(int arr[],int left,int right,int finalVal){
        //二分也是这样
        if(left > right || finalVal < arr[0] || finalVal > arr[arr.length-1]){
            return -1;
        }
        int mid = left + (right - left) * (finalVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if(midVal < finalVal){
            return chazhi(arr,mid+1,right,finalVal);
        }else if(midVal > finalVal){
            return chazhi(arr,left,mid-1,finalVal);
        }else{
            return mid;
        }

    }

}
