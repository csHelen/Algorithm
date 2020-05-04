package draw;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @program: algorithm
 * @ClassName Graph
 * @description:
 * @author: 许
 * @create: 2020-04-16 16:10
 * @Version 1.0
 **/

/**
 * 图的
 *          深度优先遍历（Depth First Search） DFS  递归过程
 *
 *          和
 *
 *          广度优先遍历(Broad First Search) BFS
 */
public class Graph {

    private ArrayList<String> vertexList;
    private int[][] edges;
    private int numOfEdges;

    //记录数组boolean[] ，记录是否被访问
    private boolean[] isVisited;

    public static void main(String[] args) {

        String vertexValue[] = {"A","B","C","D","E"};
        Graph graph = new Graph(vertexValue.length);
        for (String s : vertexValue) {
            graph.insertVertex(s);
        }
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);
        /**
         *              ---->E
         *             |
         *      A  -> B --->D
         *      |     |
         *      --- -> C
         *
         */

        graph.printf();

        graph.bfs();


    }



    public void bfs(){
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited,i);
            }
        }
    }

    //对一个节点进行广度优先遍历的方法
    public void bfs(boolean[] isVisited,int index){
        //队列，节点访问的顺序
        int u;  //表示队列的头结点对应下标
        int w;  //邻接节点
        //代替队列 ，从尾部加，从头部取
        LinkedList queue = new LinkedList<>();
        System.out.printf(getVertex(index)+"=>");
        isVisited[index] = true;
        queue.addLast(index);

        while(!queue.isEmpty()){
            u = (Integer)queue.removeFirst();
            w = getFirstNegihor(u);
            while(w != -1){
                //是否访问过
                if(!isVisited[w]){
                    System.out.printf(getVertex(w)+"=>");
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                //u为前驱，找w后面的第一个节点
                w = getNextNegihor(u,w);
            }

        }
    }



    public Graph(int n){
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        isVisited = new boolean[n];
        numOfEdges = 0;
    }

    public int getFirstNegihor(int index){
        for (int i = 0; i < vertexList.size() ; i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }
    //根据前一个邻接节点的下标来获取下一个邻接节点
    public int getNextNegihor(int v1,int v2){
        for (int i = v2+1; i < vertexList.size() ; i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

//    //DFS
    public void dfs(boolean[] isVisited,int i){
        System.out.println(getVertex(i)+"->");
        isVisited[i] = true;
        //找第一个邻接节点
        int w = getFirstNegihor(i);
        while(w != -1){
            //说明有邻接节点
            if(!isVisited[w]){
                dfs(isVisited,w);
            }
            w = getNextNegihor(i,w);
        }
    }



    public void dfs(){
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited,i);
            }
        }
    }

    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }
    //添加边
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    //图中常用的方法
    //得到点的方法
    public int getNumOfVertex(){
        return vertexList.size();
    }
    //得到边的数目
    public int getNumOfEdges(){
        return numOfEdges;
    }
    public String getVertex(int i){
        return vertexList.get(i);
    }
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }
    public void printf(){
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[0].length; j++) {
                System.out.printf(edges[i][j]+" ");
            }
            System.out.println();
        }
    }
}
