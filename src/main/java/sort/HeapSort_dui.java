package sort;

/**
 * @program: algorithm
 * @ClassName HeapSort_dui
 * @description:
 * @author: 许
 * @create: 2020-04-15 13:53
 * @Version 1.0
 **/

/**
 * 堆排序
 *          大顶堆：1、完全二叉树
 *                 2、节点值 >= 左右孩子的值  ->>>  arr[i]>=arr[2*i+1] && arr[2*+2]
 *                              50
 *                       45           40
 *                    20     25     35   30
 *                  10  15
 *           小顶堆反之
 *
 *           升序采用大顶堆，降序采用小顶堆
 *
 *           原始数组 [4,6,8,5,9]
 *           转成树
 *                         4
 *                    6        8
 *                 5    9
 *
 *           从最后一个非叶子节点  arr.length/2 -1 = 5/2 -1 = 1  --->>  arr[1]  开始调整
 *           .........
 *
 *
 */
public class HeapSort_dui {

    //用顺序存储二叉树
    public static void main(String[] args) {
        int arr[] = {4,6,8,5,9};
        print(arr);
        heapSort(arr);
        print(arr);
    }
    public static void print(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i]+" ");
        }
        System.out.println();
    }


    public static void heapSort(int arr[]){
        int temp;
        for (int i = arr.length/2 -1; i >=0; i--) {
            adjustHeap(arr,i,arr.length);
        }
        for (int i = arr.length-1; i > 0 ; i--) {
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,i);

        }
    }

    public static void adjustHeap(int arr[],int i,int length){

        int temp = arr[i];
        for (int k = i*2+1; k < length; k = k*2+1) {
            //左子节点 < 右子节点
            if( k+1< length && arr[k] <arr[k+1] ){
                //K 指向右子节点
                k++;
            }
            //右子节点 > 父节点
            if(arr[k] > temp){
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        //当 for 循环结束后，已经将以 i 为父节点的树的最大值放在了最顶(局部)
        arr[i] = temp;

    }






    public static void dui(int arr[],int i,int length){
        //获取需要遍历的叶子节点
        int node = i;
        //将当前节点与左右孩子进行比较
        getMaxIndex(arr,node,length);
        findParent(arr,node,length);
        /**
         *          4 6 8 5 9
                 * 4 9 8 5 6
                 * 9 4 8 5 6
                 * 9 6 8 5 4
         */
        print(arr);
        //互换第一个和最后一个
        int temp = arr[0];
        arr[0] = arr[length-1];
        arr[length-1] = temp;
        length--;
        dui(arr,0,length);
    }
    public static void findParent(int arr[],int node,int length){
        if(node == 0){
            return;
        }
        //父节点;
        int node_p = (node-1)/2;
        //调整
        getMaxIndex(arr,node_p,length);
        //递归继续去找父节点
        findParent(arr,node_p,length);
        //最后调节一下自己
        getMaxIndex(arr,node,length);
    }
    public static void getMaxIndex(int arr[],int node,int length){
        int temp;
        int node_l = node*2+1;
        int node_r = node*2+2;
        if(node_l < length && node_r < length ){
            //三者找最大
            int maxIndex = arr[node] > arr[node_l] ?
                    arr[node] > arr[node_r] ? node : node_r : arr[node_l] > arr[node_r] ? node_l
                    : node_r;
            //找到最大则交换
            if (maxIndex != node) {
                temp = arr[node];
                arr[node] = arr[maxIndex];
                arr[maxIndex] = temp;
            }
        }
    }
}


