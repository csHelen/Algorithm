package important;


import java.awt.*;
import java.util.ArrayList;

/**
 * @program: algorithm
 * @ClassName 马踏棋盘2
 * @description:
 * @author: 许
 * @create: 2020-04-17 22:12
 * @Version 1.0
 **/
public class 马踏棋盘2 {

    private static int H;   //表示行数
    private static int L;   //表示列数
    private static boolean isVisited[];
    private static boolean iswin;

    public static void main(String[] args) {
        H = L = 8;
        int [][] cheesboard = new int[H][L];
        isVisited  = new boolean[H*L];
        //棋盘
        //当前行下标
        //当前列下标
        //当前步数，第一步为1   当到达第36步则说明已经摆放完毕
        function(cheesboard,0,0,1);
        for (int[] rows :cheesboard){
            for (int colums : rows){
                System.out.printf(colums+"\t");
            }
            System.out.println("");
        }
    }

    //用来确认棋子可以走的下标，返回ArrayList
    public static ArrayList<Point> measure(Point point){
        ArrayList<Point> arrayList = new ArrayList<>();
        if( point.x -2 >= 0 && point.y - 1 >=0){
            arrayList.add(new Point(point.x -2,point.y - 1));
        }
        if( point.x -1 >= 0 && point.y - 2 >=0){
            arrayList.add(new Point(point.x -1,point.y - 2));
        }
        if( point.x + 1 < H && point.y - 2 >=0){
            arrayList.add(new Point(point.x +1,point.y - 2));
        }
        if( point.x + 2  < H && point.y - 1 >=0){
            arrayList.add(new Point(point.x +2,point.y -1));
        }
        if( point.x +2  < H && point.y + 1 < L){
            arrayList.add(new Point(point.x +2,point.y +1));
        }
        if( point.x +1 < H && point.y +2 < L){
            arrayList.add(new Point(point.x +1,point.y + 2));
        }
        if( point.x -1 >= 0 && point.y +2 < L){
            arrayList.add(new Point(point.x -1,point.y + 2));
        }
        if( point.x -2 >= 0 && point.y + 1 < L){
            arrayList.add(new Point(point.x -2,point.y +1));
        }
        return arrayList;
    }

    //可以放入棋子的时候走的方法
    public static void function(int[][] cheesboard,int row,int column,int step){

        cheesboard[row][column] = step;
        isVisited[row*H+column] = true;
        ArrayList<Point> ps = measure(new Point(row, column));
        ps.sort((p1,p2) -> measure(p1).size()-measure(p2).size());
        while(!ps.isEmpty()){
            Point p = ps.remove(0);
            if(!isVisited[p.x*H+p.y]){
                function(cheesboard,p.x,p.y,step+1);
            }
        }
        if(step < H*L && !iswin){
            cheesboard[row][column] = 0;
            isVisited[row*H + column] = false;
        }else{
            iswin = true;
        }

    }

}
