package important;

import com.sun.org.apache.xml.internal.security.keys.content.MgmtData;

import java.awt.*;
import java.util.ArrayList;

/**
 * @program: algorithm
 * @ClassName Prim
 * @description:
 * @author: 许
 * @create: 2020-04-17 15:28
 * @Version 1.0
 **/
public class Prim_最小生成树_图 {

    public static void main(String[] args) {
        char[] data = {'A','B','C','D','E','F','G'};
        int weight[][] = {
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000}
        };
        MinTree minTree = new MinTree();
        MGraph mGraph = new MGraph(data.length);
        minTree.createGraph(mGraph,data.length,data,weight);
        minTree.prinf(mGraph);
        prim(mGraph,0);
    }



    /**
     *
     * @param mGraph
     * @param v  从图的第几个节点进行开始生成
      */
    public static void prim(MGraph mGraph,int v){
        //访问过的节点，默认开始全为0
        int[] visited = new int[mGraph.verx];
        //当前节点表示
        visited[v] = 1;

        //h1 h2记录两个定点的下标
        int h1 = -1;
        int h2 = -1;
        int minWeight = 10000;
        //因为有 verx这么多个顶点，会生成 verx-1条边
        for (int i = 1; i < mGraph.verx; i++) {

            //j表示访问过的节点，k表示没有访问过的
            for (int j = 0; j < mGraph.verx; j++) {
                for (int k = 0; k < mGraph.verx; k++) {
                    if(visited[j] == 1 && visited[k] == 0 && mGraph.weight[j][k] < minWeight){
                        //替换minWeight位置
                        minWeight = mGraph.weight[j][k];
                        h1 = j;
                        h2 = k;
                    }
                }
            }
            //找到一条边是最小的
            System.out.println("边="+mGraph.data[h1]+","+mGraph.data[h2]+":权值："+minWeight);
            //将找到的节点标记为已经访问
            visited[h2] = 1;
            //重置
            minWeight = 10000;
        }
    }


}

class MinTree{

    public void createGraph(MGraph mGraph,int verxs,char data[],int[][]weight){
        for (int i = 0; i < verxs; i++) {
            mGraph.data[i] = data[i];
            for (int j = 0; j < verxs; j++) {
                mGraph.weight[i][j] = weight[i][j];
            }
        }
    }

    public void prinf(MGraph mGraph){
        for (int i = 0; i < mGraph.weight.length; i++) {
            for (int j = 0; j < mGraph.weight.length; j++) {
                System.out.printf(mGraph.weight[i][j]+" ");
            }
            System.out.println();
        }
    }

}

class MGraph{
    int verx;
    char[] data;
    int[][] weight;

    public MGraph(int verx){
        this.verx = verx;
        data = new char[verx];
        weight = new int[verx][verx];

    }

}
class bian{
    int start;
    int end;

    public bian(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "bian{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}