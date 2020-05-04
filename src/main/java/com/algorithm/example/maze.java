package com.algorithm.example;

/**
 * @program: algorithm
 * @ClassName migong
 * @description:
 * @author: 许
 * @create: 2020-04-16 15:06
 * @Version 1.0
 **/
public class maze {




    public static void main(String[] args) {
        int mazes[][] = {
                {0,1,0,0,0,0},
                {0,0,0,1,0,0},
                {0,0,1,0,0,1},
                {1,1,0,0,0,0}
        };
        mazeFunction(mazes,0,0);
    }

    public static void printf(int map[][]){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.printf(map[i][j]+"");
            }
            System.out.println();
        }
        System.out.println();
    }
    /**
     * 约定：
     *      0：没有走过的地方为
     *      1：墙
     *      2：可以走
     *      3：思路
     *
     */
    public static boolean mazeFunction(int map[][],int i,int j){
        if (map[map.length-1][map[0].length-1] == 2) {
            //如果目的地已经为2，说明已经走完了;
            printf(map);
            return true;
        }
        //如果超出下标返回false
        if(i == map.length || j == map[0].length){
            return false;
        }
        //比如第一个进来
        if (map[i][j] == 0) {
            //为0的时候可以走，假设走通
            map[i][j] = 2;
            //下一步，按策略走， 右 下 左 上
            if (mazeFunction(map,i+1,j)) {
                return true;
            }else if(mazeFunction(map,i,j+1)){
                return true;
            }else if(mazeFunction(map,i-1,j)){
                return true;
            }else if(mazeFunction(map,i,j-1)){
                return true;
            }else{
                //无路可走
                map[i][j] = 3;
                return false;
            }
        }else{
            return false;
        }
    }
}
