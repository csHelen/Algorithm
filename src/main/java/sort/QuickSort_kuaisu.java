package sort;

/**
 * @program: algorithm
 * @ClassName quicksort
 * @description:
 * @author: 许
 * @create: 2020-04-18 00:23
 * @Version 1.0
 **/
public class QuickSort_kuaisu {

    public static void main(String[] args) {

        int arr[] = {1,5,6,8,4,62,3,5,2,2,4,12,5,21,35,1,-5,-60,26,3};
        quickSort(arr,0,arr.length-1);
        for (int value : arr){
            System.out.printf(value+" ");
        }
    }

    public static void quickSort(int arr[],int left,int right){
        if(left <right){
            int partion = partion(arr, left, right);
            quickSort(arr,left,partion-1);
            quickSort(arr,partion+1,right);
        }


    }
    public static int partion(int arr[],int left,int right){

        int l = left;
        int r = right;
        while(l < r){
            while(l<r && arr[l] <= arr[r]){
                l++;
            }
            if(l <r ){
                arr[l] = arr[l]^arr[r];
                arr[r] = arr[l]^arr[r];
                arr[l] = arr[l]^arr[r];
                r--;
            }
            while(l<r && arr[l] <= arr[r]){
                r--;
            }
            if(l < r ){
                arr[l] = arr[l]^arr[r];
                arr[r] = arr[l]^arr[r];
                arr[l] = arr[l]^arr[r];
                l++;
            }
        }
        return l;
    }


}
