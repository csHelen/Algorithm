package com.algorithm.example;

/**
 * @program: algorithm
 * @ClassName Joseph
 * @description:
 * @author: 许
 * @create: 2020-04-13 10:50
 * @Version 1.0
 **/

/**
 * 约瑟夫  ---   单向环形链表 实现
 */
public class Joseph_约瑟夫_环单链表{

    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(2);
        circleSingleLinkedList.showBoy();

        circleSingleLinkedList.countBoy(1,3,2);
    }
}
class CircleSingleLinkedList{

    private Boy first = new Boy(-1);
    public void addBoy(int nums){
        if(nums < 1){
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if(i==1){
                first = boy;
                first.next = first;
                curBoy = first;
            }else{
                curBoy.next = boy;
                boy.next = first;
                curBoy = boy;
            }
        }
    }

    public void showBoy(){
        if (first.next == first) {
            System.out.println("没有任何小孩");
            return;
        }
        Boy temp = first;
        while(true){
            System.out.println("Boy-no:"+temp.no);
            if (temp.next==first) {
                break;
            }
            temp = temp.next;
        }
    }
    //根据用户输入输出小孩出圈顺序

    /**
     * @param startNo   表示从第几个小孩开始数数
     * @param countNum  表示数记下
     * @param nums      表示最初有多个消耗在圈内
     */
    public void countBoy(int startNo,int countNum,int nums){
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误");
            return;
        }
        //小孩    1      2    3    4    5
        //     first                  helper
        //创建辅助指针，直到指向最后一个元素
        Boy helper = first;
        while(true){
            if (helper.next == first) {
                break;
            }
            helper = helper.next;
        }
        //小孩报数时，先让first和helper移动 报数孩子的前面
        //helper 始终在 first 前面

        for (int i = 0; i < startNo-1;i++) {
            first = first.next;
            helper = helper.next;
        }

        //小孩子报数 m ，first和helper移动 m-1次，然后出圈
        //循环，直到圈中只剩一个节点
        while(true){
            if (helper == first) {
                //说明圈中只有一人
                break;
            }
            for (int i = 0; i < countNum-1; i++) {
                first = first.next;
                helper = helper.next;
            }
            //出圈操作
            //first指向的是出圈的小孩
            System.out.printf("小孩%d出圈\n",first.no);
            //出圈
            first = first.next;
            helper.next = first;
        }
        System.out.printf("最后留在圈中的小孩为小孩%d\n",first.no);
    }


}

class Boy{
    public int no;
    public Boy next;
    public Boy(int bno){
        no = bno;
    }
}