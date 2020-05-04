package important;

import java.awt.*;
import java.util.ArrayList;

/**
 * @program: algorithm
 * @ClassName 马踏棋盘
 * @description:
 * @author: 许
 * @create: 2020-04-17 20:46
 * @Version 1.0
 **/
public class 马踏棋盘 {

    private static int X;       //表示列数
    private static int Y;       //表示行数
    private static boolean isVisited[];
    private static boolean iswin;

    public static void main(String[] args) {
        X = Y = 8;
        int row = 1;
        int column = 1;
        int [][] chessboard = new int[X][Y];
        isVisited = new boolean[X*Y];
        iswin = false;

        long start = System.currentTimeMillis();
        function(chessboard,row-1,column-1,1);
        long end = System.currentTimeMillis();
        System.out.println("时间："+(end-start)+"\t");

        for (int[] rows :chessboard){
            for (int colums : rows){
                System.out.printf(colums+" ");
            }
            System.out.println("");
        }
    }

    public static void function(int[][] chessBoard,int row,int column,int step){
        chessBoard[row][column] = step;
        isVisited[row * X + column] = true;
        ArrayList<Point> ps = next(new Point(column,row));
        ps.sort((p1,p2) -> next(p1).size()-next(p2).size());
        while (!ps.isEmpty()){
            Point p = ps.remove(0);
            if(!isVisited[p.y*X+p.x]){
                function(chessBoard,p.y,p.x,step+1);
            }
        }
        if(step < X*Y && !iswin){
            chessBoard[row][column] = 0;
            isVisited[row*X + column] = false;
        }else{
            iswin = true;
        }

    }

    //将当前节点可以走的位置用ArrayList保存并返回
    public static ArrayList<Point> next(Point curPoint){
        ArrayList<Point> ps = new ArrayList<Point>();
        Point p1 = new Point();
        //上边 ，Y都是减号
        if((p1.x = curPoint.x - 2)>=0 && (p1.y = curPoint.y - 1) >= 0){
            ps.add(new Point(p1));
        }
        if((p1.x = curPoint.x - 1)>=0 && (p1.y = curPoint.y - 2) >= 0){
            ps.add(new Point(p1));
        }
        if((p1.x = curPoint.x +1) <X && (p1.y = curPoint.y - 2) >= 0){
            ps.add(new Point(p1));
        }
        if((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y - 1) >= 0){
            ps.add(new Point(p1));
        }


        //下边，Y都是+号
        if((p1.x = curPoint.x + 2) <X && (p1.y = curPoint.y + 1) < Y){
            ps.add(new Point(p1));
        }
        if((p1.x = curPoint.x + 1) <X && (p1.y = curPoint.y + 2) < Y){
            ps.add(new Point(p1));
        }
        if((p1.x = curPoint.x - 1)>=0 && (p1.y = curPoint.y + 2) < Y){
            ps.add(new Point(p1));
        }
        if((p1.x = curPoint.x - 2)>=0 && (p1.y = curPoint.y + 1) <Y){
            ps.add(new Point(p1));
        }
       return ps;
    }

}
