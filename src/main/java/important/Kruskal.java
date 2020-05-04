package important;

import java.util.Arrays;

/**
 * @program: algorithm
 * @ClassName Kruskal_最小生成树_图
 * @description:
 * @author: 许
 * @create: 2020-04-19 07:19
 * @Version 1.0
 **/
public class Kruskal {

    private int edgeNum;
    private char[] vertexs;
    private int[][] matrix;
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertexs = {'A','B','C','D','E','F','G'};
        int matrix[][] = {
                {   0       , 12   , INF    , INF   , INF    , 16   , 14     },
                {   12      , 0    , 10     , INF   , INF    , 7    , INF    },
                {   INF     , 10   , 0      , 3     , 5      , 6    , INF    },
                {   INF     , INF  , 3      , 0     , 4      , INF  , INF    },
                {   INF     , INF  , 5      , 4     , 0      , 2    , 8      },
                {   16      , 7    , 6      , INF   , 2      , 0    , 9      },
                {   14      , INF  , INF    , INF   , 8      , 9    , 0      }
        };
        Kruskal kruskal = new Kruskal(vertexs,matrix);
        kruskal.print();
        kruskal.krusalCore();


    }

    public void krusalCore(){
        int index = 0;  //表示最后结果数组的索引
        int[] ends = new int[edgeNum];  //用于保存“已有最小生成树中的每个顶点在最小生成树中的终点
        EData[] result = new EData[edgeNum];

        //获取图中所有的边的集合，一共有12条边
        EData[] edges = getEdges();

        mergeSortEdges(edges);
        System.out.println(Arrays.toString(edges));

        for (int i = 0; i < edgeNum; i++) {
            int p1 = getPosition(edges[i].start);
            int p2 = getPosition(edges[i].end);

            int m = getEnd(ends,p1);
            int n = getEnd(ends,p2);
            if(m != n){
                //不构成回路
                ends[m] = n;    //设置 m在已有最小生成树的终点
                result[index++] = edges[i];
            }
        }

        for (int i = 0; i < index; i++) {
            System.out.println(result[i]);
        }
    }

    /**
     * 功能：获取下标为i的顶点的重点
     * @param ends  ：记录了各个顶点对应的终点是哪个？在遍历过程中逐步形成的
     * @param i  表示传入的顶点对应的下标
     * @return   返回终点下标
     */
    public int getEnd(int ends[],int i){
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }

    public int getPosition(char ch){
        for (int i = 0; i < vertexs.length; i++) {
            if(vertexs[i] == ch){
                return i;
            }
        }
        return -1;
    }
    private EData[] getEdges(){
        int index = 0;
        EData[] edges = new EData[edgeNum];
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i+1; j < vertexs.length; j++) {
                if(matrix[i][j] != INF){
                    edges[index++] = new EData(vertexs[i],vertexs[j],matrix[i][j]);
                }
            }
        }

        return edges;
    }
    public void print(){
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = 0; j < vertexs.length; j++) {
                System.out.printf("%12d\t",matrix[i][j]);
            }
            System.out.println("");
        }
    }

    //采用归并排序
    public void mergeSortEdges(EData[] edges){
        EData[] temp = new EData[edges.length];
        mergeSortEdges(edges,0,edgeNum-1,temp);
    }

    public void mergeSortEdges(EData[] edges,int left,int right,EData[] temp){
        if(left<right){
            int mid = (left+right)/2;
            mergeSortEdges(edges,left,mid,temp);
            mergeSortEdges(edges,mid+1,right,temp);
            handleMergeSort(edges,left,mid,right,temp);
        }

    }
    public void handleMergeSort(EData[] edges,int left,int mid,int right,EData[] temp){
        int l = left;
        //别老是搞错是 r = right
        int r = mid+1;
        int t = 0;
        while(l <= mid && r <= right){
            if(edges[l].weight < edges[r].weight){
                temp[t] = new EData(edges[l].start,edges[l].end,edges[l].weight);
                t++;
                l++;
            }else{
                temp[t] = new EData(edges[r].start,edges[r].end,edges[r].weight);
                t++;
                r++;
            }
        }
        while(l <= mid){
            temp[t] = new EData(edges[l].start,edges[l].end,edges[l].weight);
            t++;
            l++;
        }
        while(r <= right){
            temp[t] = new EData(edges[r].start,edges[r].end,edges[r].weight);
            t++;
            r++;
        }
        t = 0;
        int tempIndex = left;
        while(tempIndex<=right){
            edges[tempIndex] = new EData(temp[t].start,temp[t].end,temp[t].weight);
            t++;
            tempIndex++;
        }
    }


    public Kruskal(char[] vertexs,int[][] matrix){
        int vlen = vertexs.length;
        this.vertexs = new char[vlen];
        for (int i = 0; i < vlen; i++) {
            this.vertexs[i] =  vertexs[i];
        }
        this.matrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++) {
                this.matrix[i][j] =  matrix[i][j];
            }
        }
        for (int i = 0; i < vlen; i++) {
            for (int j = i+1; j < vlen; j++) {
                if (this.matrix[i][j] != INF){
                    edgeNum++;
                }
            }
        }
    }
}

//创建一个类EData
class EData{
    char start;
    char end;
    int weight;

    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EData{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }
}
