package sort;

/**
 * @program: algorithm
 * @ClassName 希尔排序
 * @description:
 * @author: 许
 * @create: 2020-04-18 16:54
 * @Version 1.0
 **/
public class 希尔排序 {

    public static void main(String[] args) {
        int arr[] = {1,5,6,84,6,5,2,3,6,2,5,3,1,5,2,6,10};

        xier(arr);

        for(int a : arr){
            System.out.printf(a +" ");
        }


    }

    private static void xier(int[] arr) {

        int length = arr.length;

        while(length!=0){
            length /= 2;
            // 1,5,6,84,6,5,2,3,6,2,5,3,1,5,2,6,10
            for (int i=0;i<length;i++){
                for (int j = i; j < arr.length; j+= length) {
                    //实现插入排序


                }
            }

        }


    }

}
