package com.algorithm.example;

/**
 * @program: algorithm
 * @ClassName Maze
 * @description:
 * @author: 许
 * @create: 2020-04-14 00:30
 * @Version 1.0
 **/

/**
 * 迷宫
 */
public class Maze_迷宫_递归 {


    /**
     * @param map
     * @param i j 触发地址
     *          约定：
     *          map[i][j] 0:没走过  1:墙  2:有通路可走  3:走过但走不通
     *          在走迷宫是，需要确定一个策略（方法）下 - 右 - 上  - 左，如果该点走不通再回溯
     *
     *          最短路径？与策略有关
     * @return
     */
    public static boolean findWay(int[][] map,int i,int j){

        if(map[6][5] == 2){
            return true;
        }else{
            if (map[i][j] == 0) {
                //按策略走
                map[i][j] = 2;  //假设能走通
                if(findWay(map,i+1,j)){  //向下走
                    return true;
                }else if(findWay(map,i,j+1)){  //向右走
                    return true;
                }else if(findWay(map,i-1,j)) {  //向上走
                    return true;
                }else if(findWay(map,i,j-1)) {  //向左走
                    return true;
                }else{
                    map[i][j] = 3;     //说明该点走不通;
                    return false;
                }
            }else{
                return false;
            }
        }
    }

    public static void main(String[] args) {
        int[][] map = new int[8][7];
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        map[2][2] = 1;
        //输出地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.printf(map[i][j]+"  ");
            }
            System.out.println();
        }

        findWay(map,1,1);
        System.out.println();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.printf(map[i][j]+"  ");
            }
            System.out.println();
        }
    }

}
