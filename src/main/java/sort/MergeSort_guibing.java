package sort;

/**
 * @program: algorithm
 * @ClassName MergeSort_guibing
 * @description:
 * @author: 许
 * @create: 2020-04-14 14:24
 * @Version 1.0
 **/

/**
 * 归并排序
 *      分支
 */
public class MergeSort_guibing {

    public static void main(String[] args) {
        int arr[] = {2,5,6,8,4,14,123,5,235,24,3,123,5,123,124,1,3,9,7};
        int temp[] = new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i]+" ");
        }
    }
    //归并中的合并方法
    public static void mergeSort(int arr[],int left,int right,int []temp){
        if(left < right){
            int mid = (left + +right) / 2;
            mergeSort(arr,left,mid,temp);
            mergeSort(arr,mid+1,right,temp);
            guibing(arr,left,mid,right,temp);
        }
    }
    /**
     *  归并中的分开方法
     * @param arr
     * @param left
     * @param mid   中间索引
     * @param right
     * @param temp  中转站
     */
    public static void guibing(int arr[],int left,int mid,int right,int []temp){
        int i = left;       //初始化i，左边有序序列的初始索引
        int j = mid +1;     //初始化j，右边有序序列的初始索引
        int t =0;           //指向temp数组的当前索引
        //第一步
        //先把左右两边（有序的数据按照规划填充到temp数组
        //知道左右两边的有序序列，其中一边处理完毕为止
        while(i <= mid && j <= right){
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            }else{
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        //第二步
        //把剩余数据的一边的数据一次全部填充到temp
        while(i<=mid){
            temp[t] = arr[i];
            t++;
            i++;
        }
        while(j <= right){
            temp[t] = arr[j];
            t++;
            j++;
        }

        //第三步
        //把temp的数组的元素拷贝到arr
        t = 0;;
        int tempLeft = left;
        while(tempLeft <= right){
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }

    }



}
