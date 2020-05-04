package sort;

/**
 * @program: algorithm
 * @ClassName ShellSort_xier
 * @description:
 * @author: 许
 * @create: 2020-04-14 12:42
 * @Version 1.0
 **/

import java.util.Random;

/**
 * 希尔排序  改进了 插入排序
 */
public class ShellSort_xier {

    public static void main(String[] args) {
//        int []arr = new int[10];
        //

//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = (int) (Math.random()*8000000);
//        }
        int arr[] = {1,5,6,8,46,5,2,3,1,52,-2,6,5,3,-8,6,456,65,12,3,8,9,5};
        long start = System.currentTimeMillis();
//        xier_jiaohuan(arr);     //交换法15s
                xier_yiwei(arr);        //移位法1s
        long end = System.currentTimeMillis();
        System.out.println("time:"+(end-start));
        printf(arr);


    }
    public static void printf(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i]+" ");
        }
        System.out.println();
    }

    public static void xier_jiaohuan(int arr[]){
//        printf(arr);
        int length = arr.length;
        while( length/2 > 0){
            length /= length;
            for (int i = length; i < arr.length; i++) {
                for (int j = i-length; j >= 0; j -=length) {
                    if (arr[j] > arr[j+length]) {
                        //
                        //    这里 交换 代价太高了
                        //
                        int temp = arr[j];
                        arr[j] = arr[j+length];
                        arr[j+length] = temp;

                    }
                }
            }
        }
//        printf(arr);
    }

    public static void xier_yiwei(int arr[]){
//        printf(arr);
        int length = arr.length;
        while( length/2 > 0){
            length /= 2;
            for (int i = length; i < arr.length; i++) {

                int j = i;
                int temp = arr[j];

//                if (arr[j] < arr[j-length]) {
                while(j-length >= 0 && temp < arr[j-length]){
                    //这里就不是看到就交换，而是先移动最后不能动了再交换
                    arr[j] = arr[j-length];
                    j -= length;
                }
                arr[j] = temp;
//                }

            }
        }
//        printf(arr);
    }
}
