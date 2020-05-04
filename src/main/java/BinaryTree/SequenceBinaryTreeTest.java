package BinaryTree;

/**
 * @program: algorithm
 * @ClassName SequenceBinaryTreeTest
 * @description:
 * @author: 许
 * @create: 2020-04-15 11:05
 * @Version 1.0
 **/

/**
 * 顺序存储二叉树
 *      必须是 完全二叉树
 *                  1
 *               2      3
 *            4   5   6   7
 *      第n个元素的左子节点为 2*n+1
 *      第n个元素的右子节点为 2*n+2
 *      第n个元素的父子节点为 (n-1)/2
 *
 *      以3为例   存储在位置 arr[2]
 *      第2个元素的左子节点为 2*2+1=5  arr[5] = 6 没错
 *      第2个元素的右子节点为 2*2+2=6  arr[6] = 7 没错
 *      第2个元素的父子节点为 (2-1)/2 = 1/2=0  arr[0] = 1 没错
 */
public class SequenceBinaryTreeTest {


    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.infixOrder();
    }

}
class ArrBinaryTree{
    int[] arr;

    public ArrBinaryTree(int arr[]){
        this.arr = arr;
    }
    public void preOrder(){
        preOrder(0);
    }
    public void infixOrder(){
        infixOrder(0);
    }
    public void postOrder(){
        postOrder(0);
    }
    public void preOrder(int index){
        if (arr == null || arr.length == 0){
            System.out.println("为空");
        }
        System.out.println(arr[index]);
        if((index*2 +1)<arr.length){
            preOrder(2*index +1);
        }
        if((index*2 +2)<arr.length){
            preOrder(2*index +2);
        }
    }
    public void infixOrder(int index){
        if (arr == null || arr.length == 0){
            System.out.println("为空");
        }

        if((index*2 +1)<arr.length){
            infixOrder(2*index +1);
        }
        System.out.println(arr[index]);
        if((index*2 +2)<arr.length){
            infixOrder(2*index +2);
        }
    }
    public void postOrder(int index){
        if (arr == null || arr.length == 0){
            System.out.println("为空");
        }
        if((index*2 +1)<arr.length){
            postOrder(2*index +1);
        }
        if((index*2 +2)<arr.length){
            postOrder(2*index +2);
        }
        System.out.println(arr[index]);
    }

}


