package sort;

/**
 * @program: algorithm
 * @ClassName Bubble
 * @description:
 * @author: 许
 * @create: 2020-04-14 10:32
 * @Version 1.0
 **/

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 冒泡排序
 *      比如从小到大
 *      比较相邻元素，逆序则交换
 *          每一趟确定了最后一个元素
 *
 *      优化：设置变量，如果没有交换说明已经有序，提前退出
 */
public class BubbleSort_maopao {

    public static void maopao(int arr[]){
        int max = arr.length-1;
        boolean flag = false;
        for (int i = 0; i < max;i++) {
            for (int j = 0; j < max-i; j++) {
                if (arr[j] > arr[j+1]) {
                    flag = true;
                    arr[j] = arr[j]^arr[j+1];
                    arr[j+1] = arr[j]^arr[j+1];
                    arr[j] = arr[j]^arr[j+1];
                }
            }
            if(!flag){
                break;
            }else{
                flag = false;
            }
        }
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
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
        maopao(randomArr);
        Date end = new Date();
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(end));
    }
}
