package com.algorithm.example;

/**
 * @program: algorithm
 * @ClassName HoffmanTree_哈弗曼树
 * @description:
 * @author: 许
 * @create: 2020-04-15 15:23
 * @Version 1.0
 **/

import java.util.ArrayList;

/**
 * 赫夫曼树
 *      结点的权 和 带权路径长度（权值*路径(层数-1) -3个点路径是2）
 *      树的带权路径长度：所有的叶子结点的 带权路径长度 之和
 *               o
 *           o       o
 *        13  7     8  3     wpl = 13*2  +  7*2   +  8*2   +  3*2  = 62
 *
 *        wpl最小的就是赫夫曼树
 *          weighted path length   树的带权路径长度
 *
 *        题： 给一个数列【 13,7,8,3,29,6，1 】 要求转成一颗赫夫曼树
 *        步骤：
 *              1、排序【 1,3,6,7,8,13,29】
 *                      取 1 + 3 = 4
 *              2、排序【 4,6,7,8,13,29】
 *                      取 4 + 6 = 10
 *              3、排序【 7,8,10,13,29】
 *                      取 7 + 8 = 15
 *              4、排序【 10,13,15,29】
 *                      取 10 + 13 = 23
 *              5、排序【 15,23,29】
 *                      取 15 + 23 = 38
 *              6、排序【 29,38】
 *  *                   取 29 + 38 = 67
 *
 *                  67
 *           29           38
 *                15              23
 *            7      8         10    13
 *                           4    6
 *                         1   3
 *
 *

 *
 */
public class HoffmanTree_赫夫曼树 {

    public static void main(String[] args) {
        int arr [] = {13,7,8,3,29,6,1};
        Node node = createHuffmanTree(arr);
        preOrder(node);


    }
    //先序遍历
    public static void preOrder(Node node){
        System.out.printf(node.ch+" ");
        if (node.left != null) {
            preOrder(node.left);
        }
        if (node.right != null) {
            preOrder(node.right);
        }


    }

    public static Node createHuffmanTree(int arr[]){
        ArrayList<Node> list = getList(arr);

        while(true){
            if(list.size()==1){
                break;
            }
            //取出最小的两个结点
            Node left = list.get(0);
            Node right = list.get(1);

            Node parent = new Node(left.value + right.value,'@');
            parent.left = left;
            parent.right = right;

            list.remove(0);
            list.remove(0);
            list.add(parent);
            //排序
            list.sort((n1,n2) -> n1.value - n2.value);
            System.out.println(list);
        }
        return list.get(0);
    }

    //lambda实现数组排序
    public static ArrayList<Node> getList(int arr[]){
        ArrayList<Node> list = new ArrayList();
        int test[] = {1,1,1,2,2,2,4,4,4,5,5,9};
        char testCh[] = {'d','y','u','j','v','o','l','k','e','i','a','-'};

        for (int i = 0; i < test.length; i++) {
            list.add(new Node(test[i],testCh[i]));
        }
        list.sort((n1,n2) -> n1.value - n2.value);
//        list.forEach(System.out::println);
        return list;
    }



}

class Node{
    int value;
    char ch;
    Node left;
    Node right;

    public Node(int value, char ch) {
        this.value = value;
        this.ch = ch;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", ch=" + ch +
                '}';
    }
}
