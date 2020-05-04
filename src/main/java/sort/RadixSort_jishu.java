package sort;

/**
 * @program: algorithm
 * @ClassName RadixSort_ji
 * @description:
 * @author: 许
 * @create: 2020-04-14 19:50
 * @Version 1.0
 **/

/**
 * 基数排序  “分配式排序”
 *      桶排序的扩展
 *      过程
 *
 *      数组  53  3  542  748  14  214
 *
 *
 */
public class RadixSort_jishu {

    public static void main(String[] args) {
        int arr[] = {5,2,5526,156,23,15,6,23,56549,5621,3,21,5,6};
        jishu(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i]+" ");
        }
    }

    public static void jishu(int arr[]){

        //找出数组最大值，确定遍历次数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(max < arr[i]){
                max = arr[i];
            }
        }
        //获得最大数是几位数
        int maxLength = (max+"").length();
        //二维数组--桶
        int bucket[][] = new int[10][arr.length];
        //二维数组的有效个数记为一个一位数组
        int bucketNum[] = new int[10];


        int index = 0;

        for (int i = 0,n=1; i < maxLength; i++,n*=10) {
            //将数组中的元素放入10个桶中
            for (int j = 0; j < arr.length; j++) {
                int digitOfElement = arr[j] / n % 10;
                bucket[digitOfElement][bucketNum[digitOfElement]] = arr[j];
                bucketNum[digitOfElement]++;
            }
            //将桶中的元素放回数组
            for (int k = 0;  k < bucketNum.length; k++) {
                if (bucketNum[k] != 0) {
                    //有数据
                    for (int j = 0; j < bucketNum[k]; j++) {
                        arr[index] = bucket[k][j];
                        index++;
                    }
                }

            }
            index = 0;
            //将桶记录的一位数组置零
            for (int j = 0; j < bucketNum.length; j++) {
                bucketNum[j] = 0;
            }
        }
    }

}
