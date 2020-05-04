package important;

/**
 * @program: algorithm
 * @ClassName DynamicProgramming_动态规划_背包
 * @description:
 * @author: 许
 * @create: 2020-04-16 23:31
 * @Version 1.0
 **/
public class DynamicProgramming_动态_背包 {


    public static void main(String[] args) {

        int[] w = {1,4,3};              //物品的重量
        int[] val = {1500,3000,2000};     //背包的价值
        int m = 4;                      //背包的重量
        int n = val.length;



        //创建二维数组
        int [][] v = new int[n+1][m+1];
        //记录存放情况
        int [][] path = new int[n+1][m+1];


        //初始化第一行第一列均为0，但默认为0
        //...假设处理了 v[i][0] = 0  v[0][i]=0
        for (int i = 0; i < v.length; i++) {
            v[i][0]=0;
        }
        for (int i = 0; i < v[0].length; i++) {
            v[0][i]=0;
        }

        //利用公式来动态规划处理
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                if(w[i-1] > j){
                    v[i][j] = v[i-1][j];
                }else{
                    //因为val,w都需要调整一下
//                    v[i][j] = Math.max(v[i-1][j],val[i-1] + v[i-1][j-w[i-1]]);
                    if(v[i-1][j] < val[i-1] + v[i-1][j-w[i-1]]){
                        v[i][j] = Math.max(v[i-1][j],val[i-1] + v[i-1][j-w[i-1]]);
                        path[i][j] = 1;
                    }else{
                        v[i][j] = v[i-1][j];
                    }
                }
            }
        }

        //遍历
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[0].length; j++) {
                System.out.printf(v[i][j]+" ");
            }
            System.out.println("");
        }

        int i = path.length-1;
        int j = path[0].length-1;
        while(i>0 && j>0){
            if(path[i][j] == 1){
                System.out.printf("第%d个商品放入到背包\n",i);
                j -= w[i-1];
            }
            i--;
        }

    }

}
