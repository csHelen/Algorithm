package com.algorithm.example;

/**
 * @program: algorithm
 * @ClassName EightQueen
 * @description:
 * @author: 许
 * @create: 2020-04-14 01:05
 * @Version 1.0
 **/

public class EightQueen_八皇后_递归 {

    int max = 8;
    int[] array = new int[8];
    static int count = 0;
    public static void main(String[] args) {
        EightQueen_八皇后_递归 eightQueen = new EightQueen_八皇后_递归();
        eightQueen.check(0);
        System.out.println("count==="+count);
    }
    //放置皇后的方法
    public void check(int n){
        if (n == max) {
            //max = 8 ，在放第9个皇后，就是8个皇后已经放好了
            print();
            return;
        }
        //依次放入皇后
        for (int i = 0; i < max; i++) {
            //当前第n个皇后，放到该行的第一列
            array[n] = i;
            if(judge(n)){
                check(n+1);
            }
        }
    }

    //查看当我们放置第n个皇后，就去检测该皇后是否和前面已经摆放的皇后冲突
    public boolean judge(int n){
        for (int i = 0; i < n; i++) {
            //Math.abs(n-i) == Math.abs(array[n] - array[i]) 对角线斜率,是否在同一斜线
            if (array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i]))  {
                return false;
            }
        }
        return true;
    }

    public void print(){
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.printf(array[i]+" ");
        }
        System.out.println();
    }



}
