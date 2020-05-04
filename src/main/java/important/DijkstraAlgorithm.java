//package important;
//
///**
// * @program: algorithm
// * @ClassName DijkstraAlgorithm
// * @description:
// * @author: 许
// * @create: 2020-04-19 11:44
// * @Version 1.0
// **/
//
//import java.util.Arrays;
//
///**
// *      最短路径
// */
//public class DijkstraAlgorithm {
//
//    public static void main(String[] args) {
//        char[] vertex = {'A','B','C','D','E','F','G'};
//        int[][] matrix = new int[vertex.length][vertex.length];
//        final int N = 65535;
//        matrix[0]=new int[]{N,5,7,N,N,N,2};
//        matrix[1]=new int[]{5,N,N,9,N,N,3};
//        matrix[2]=new int[]{7,N,N,N,8,N,N};
//        matrix[3]=new int[]{N,9,N,N,N,4,N};
//        matrix[4]=new int[]{N,N,8,N,N,5,4};
//        matrix[5]=new int[]{N,N,N,4,5,N,6};
//        matrix[6]=new int[]{2,3,N,N,4,6,N};
//        //创建 Graph对象
//        Graph graph = new Graph(vertex, matrix);
//        //测试, 看看图的邻接矩阵是否ok
//        graph.showGraph();
//        graph.dsj2(6);
//
//    }
//
//}
//
//class Graph{
//    public char[] vertex;
//    public int[][] matrix;
//    public VisistedVertext vv;
//    public Graph(char[] vertex, int[][] matrix) {
//        this.vertex = vertex;
//        this.matrix = matrix;
//    }
//
//
//    public void showGraph(){
//        for (int[] ints : matrix) {
//            System.out.println(Arrays.toString(ints));
//        }
//    }
//
//    /**
//     * 最短路径：广度遍历
//     * @param index   遍历起点
//     */
//    public void dsj2(int index){
//        //根据起点建立对象
//        //将该对象下标为 index 访问节点置为 1：访问状态
//        //将对象的路径长度置为 0
//        vv = new VisistedVertext(vertex.length,index);
//        vv.show();
//        /**
//         * [1, 0, 0, 0, 0, 0, 0]
//         * [0, 0, 0, 0, 0, 0, 0]
//         * [0, 65535, 65535, 65535, 65535, 65535, 65535]
//         */
//        //访问 该节点 连接的 所有节点
//        int len = 0;
//        for (int i = 0; i < vertex.length; i++) {
//            if(i == index){
//                continue;
//            }
//            len = matrix[index][i];
//            if(len < 65535){
//                vv.already_arr[i] = 1;
//                vv.dis[i] = len;
//            }
//
//        }
//        vv.show();
//        //找出最小的节点进行遍历
//        int minNum = 65535;
//        int minIndex = -1;
//        for (int i = 0; i <vertex.length ;i++) {
//            int len = vv.dis[i] + matrix[i][]
//            if(vv.already_arr[i] == 0 &&  < minNum){
//                minNum = vv.dis[i];
//                minIndex = i;
//            }
//        }
//        System.out.println(minNum);
//        System.out.println(minIndex);
//
//    }
//
//    //迪杰斯特拉算法
//    public void dsj(int index){
//        vv = new VisistedVertext(vertex.length,index);
//        update(index);
//        System.out.println("");
//        for (int j = 1;j<vertex.length;j++){
//            index = vv.updateArr();
//            update(index);
//        }
//        vv.show();
//
//    }
//    //更新index下标顶点到周围为顶点的距离和周围顶点的前去定点
//
//    public void update(int index){
//        int len = 0;
//        //遍历邻接矩阵
//        for (int i = 0; i < matrix[index].length; i++) {
//            //len表示：触发顶点到index顶点的具体 + 从index顶点到j顶点的距离的和
//            len = vv.getDis(index) + matrix[index][i];
//            //如果I顶点没有被访问过，并且len小于出发顶点到I顶点的距离，就需要跟新
//            if(!vv.in(i) && len < vv.getDis(i)){
//                //跟新I顶点的前驱节点为index
//                vv.updatePre(i,index);
//                //更新触发顶点到I顶点的距离
//                vv.updateDis(i,len);
//            }
//        }
//        //
//
//
//    }
//
//}
//
//class VisistedVertext{
//    //记录各个顶点是否访问过， 1表示访问过，0未访问，会动态更新
//    public int[] already_arr;
//    //每个下标对应的值为前一个顶点下标，会动态更新
//    public int[] pre_visited;
//    //记录触发顶点到其他所有顶点的距离，比如G为出发点，
//    // 就会记录G到其他顶点的距离，会动态跟新，求的最短距离就会存放在dis
//    public int[] dis;
//
//    /**
//     * @param length    顶点个数
//     * @param index     G顶点，传进来就是6
//     */
//    public VisistedVertext(int length,int index){
//        this.already_arr = new int[length];
//        this.pre_visited = new int[length];
//        this.dis = new int[length];
//
//        Arrays.fill(dis,65535);
//        already_arr[index] = 1; //出发顶点被访问过
//        dis[index] = 0;         //设置出发顶点的访问距离为0
//    }
//
//    /**
//     * 判断index顶点是否被访问过
//     * @param index
//     * @return
//     */
//    public boolean in(int index){
//        return already_arr[index] == 1 ? true : false;
//    }
//
//    /**
//     * 功能：更新出发顶点到index顶点的距离
//     * @param index
//     * @param len
//     */
//    public void updateDis(int index, int len){
//        dis[index] = len;
//    }
//
//    /**
//     * 功能：更新顶点的前驱为index的节点
//     * @param pre
//     * @param index
//     */
//    public void updatePre(int pre,int index){
//        pre_visited[pre] = index;
//
//    }
//
//    /**
//     * 功能：返回出发顶点到index的距离
//     * @param index
//     */
//    public int getDis(int index){
//        return dis[index];
//    }
//
//    //继续选择并返回新的访问远点，比如G走完后，A作为新的访问顶点，但不再是出发点了
//    public int updateArr(){
//        int min = 65535,index = 0;
//        for (int i = 0; i < already_arr.length; i++) {
//            if (already_arr[i] == 0 && dis[i] < min){
//                min = dis[i];
//                index = i;
//            }
//        }
//        already_arr[index] = 1;
//        return index;
//    }
//
//    public void show(){
//        System.out.println("====================");
//        System.out.println(Arrays.toString(already_arr));
//        System.out.println(Arrays.toString(pre_visited));
//        System.out.println(Arrays.toString(dis));
//
//    }
//
//}