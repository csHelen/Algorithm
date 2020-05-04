package sort;

/**
 * @program: algorithm
 * @ClassName SelectionSort_xuanze
 * @description:
 * @author: 许
 * @create: 2020-04-14 11:03
 * @Version 1.0
 **/

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 选择排序
 *    思路
 *      从0~n-1找最小的与0交换
 *      第二次从1~n-1找最小的与1交换
 */
public class SelectionSort_xuanze {
    public static void xuanze(int arr[]){
        for (int i = 0; i < arr.length-1; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < min){
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }

    }
    public static void main(String[] args) {
        int arr[] = new int[]{3,9,-1,9,1,3,-9,1,2,5,6,8,1,6,3,-100,6,-10,5,5};
        testRate();

    }
    public static void testRate(){
        int[] randomArr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            randomArr[i] = (int)(Math.random() * 800000); //[0,800000)
        }

        Date start = new Date();
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(start));
        xuanze(randomArr);
        Date end = new Date();
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(end));
    }
}
