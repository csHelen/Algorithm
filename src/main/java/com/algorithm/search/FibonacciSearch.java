package com.algorithm.search;

/**
 * @program: algorithm
 * @ClassName FibonacciSearch
 * @description:
 * @author: 许
 * @create: 2020-04-14 21:31
 * @Version 1.0
 **/

import java.util.Arrays;

/**
 * 斐波那契（黄金分割法）查找算法
 *      黄金分割点：
 *          一条尖端分割为两部分，是
 *          其中一部分 与 全长之比  等于另一部分与这部分之比，
 *          取其前三维数字的近似值是0.618，
 *          由于接近比例设计的造型十分美丽，因此成为黄金分割，
 *
 *       斐波那契数列
 *              1  1  2  3  5  8  13  21  34  55   第三者为前两者之和
 *              2 3 5  3/5 = 0.6
 *              13  21 34  21 / 34 = 0.617
 */
public class FibonacciSearch {

    public static void main(String[] args) {

        int []arr = {1,8,10,89,1000,1234};
        System.out.println(fibSearch(arr, 1000));


    }

    public static int fibSearch(int []a,int key){
        int low = 0;
        int high = a.length-1;
        int k = 0;  //表示fibonacci分割数值的下标

        int mid = 0;

        int fibonacciArr[] = new int[20];
        for (int i = 1; i <= 20; i++) {
            fibonacciArr[i-1] = getFab(i);
        }

        while(high > fibonacciArr[k] - 1){
            k++;
        }
        int[] temp = Arrays.copyOf(a,fibonacciArr[k]);
        for (int i = high+1; i < temp.length; i++) {
            temp[i] = a[high];
        }

        while (low <= high) {
            mid = low + fibonacciArr[k-1]-1;
            if(key < temp[mid]){
                //向数组左边查找
                high = mid -1;
                //全部元素 =  前面的元素 + 后边的元素
                //  f[k] = f[k-1] + f[k-2]
                // 因为前面有f[k-1]个元素，所以可以继续拆分f[k-1] = f[k-2] + f[k-3]
                k--;
            }else if(key > temp[mid]){
                low = mid +1;
                k -= 2;
            }else{
                if(mid <= high){
                    return mid;
                }else{
                    return high;
                }
            }
        }
        return -1;
    }

    public static int getFab(int n){
        if(n==1 || n==2){
            return 1;
        }else{
            return getFab(n-1) + getFab(n-2);
        }
    }

}
