package array;

/**
 * @program: algorithm
 * @ClassName SparseArray
 * @description:
 * @author: 许
 * @create: 2020-04-12 23:40
 * @Version 1.0
 **/
//稀疏数组 -》>
public class SparseArrayTest {

    public static void main(String[] args) {
        //创建一个原始的二位数组 11 * 11
        //0 表示没有旗子  ， 1表示黑色  2 表示白色
        int chessArr[][] = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[3][5] = 2;
        System.out.println("原先二维数组");
        for(int[] row : chessArr){
            for(int data :row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        //将二维数组转成稀疏素组
        int sum = 0;

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(chessArr[i][j] != 0){
                    ++sum;
                }
            }
        }
        //创建稀疏数组
        int sparseArr[][] = new int[sum+1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        int k = 0;
        int sparseArrNum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(chessArr[i][j] != 0){
                    ++k;
                    sparseArrNum++;
                    sparseArr[sparseArrNum][0] = i;
                    sparseArr[sparseArrNum][1] = j;
                    sparseArr[sparseArrNum][2] = chessArr[i][j];
                    if(k == sum){
                        break;
                    }
                }
            }
            if(k == sum){
                break;
            }
        }

        System.out.println("元素个数==="+sum);
        System.out.println("换成稀疏数组");
        for(int[] row : sparseArr){
            for(int data :row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //恢复成稀疏数组
        System.out.println("提取的二维数组");
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr[0][2]+1; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        for(int[] row : chessArr2){
            for(int data :row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

    }

}
