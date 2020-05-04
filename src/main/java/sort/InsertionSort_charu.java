package sort;

/**
 * @program: algorithm
 * @ClassName InsertionSort_charu
 * @description:
 * @author: 许
 * @create: 2020-04-14 11:19
 * @Version 1.0
 **/

/**
 * 插入排序
 *        分为有序和无序表
 *        开始有序表只有一个，将无序表元素插入到有序表中
 */
public class InsertionSort_charu {

    public static void main(String[] args) {
        int arr[] = {102,3,6,4,6,8,2,60};
        charu(arr);
    }

    public static void charu(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int inserIndex = i-1;
            while(inserIndex >= 0 && arr[inserIndex] > insertVal){
                arr[inserIndex+1]=arr[inserIndex];
                inserIndex--;
            }
            if (inserIndex + 1 != i) {
                arr[inserIndex+1] = insertVal;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i]+" ");
        }
    }

}
