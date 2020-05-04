package important;

/**
 * @program: algorithm
 * @ClassName BinarySort_fei
 * @description:
 * @author: 许
 * @create: 2020-04-16 20:34
 * @Version 1.0
 **/

/**
 *
 *      学习非递归的方式去实现二分查找算法
 *
 *      时间复杂O(log2 n)
 *      比如0-99 100个数，    2的6次方 <  100  < 2的7次方   最多需要7次
 *
 */
public class BinarySort_非递归_查询 {

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(binarySearch(arr, 9));
    }
    public static int binarySearch(int arr[],int target){

        int left = 0;
        int right = arr.length-1;
        while(left <= right){
            int mid = (left+right)/2;
            if (arr[mid] == target){
                return mid;
            }else if(arr[mid] < target){
                //大于，在右边找，移动left指针
                left = mid+1;
            }else{
                right  = mid-1;
            }
        }
        return -1;
    }

}
