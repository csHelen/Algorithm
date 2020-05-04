package important;

/**
 * @program: algorithm
 * @ClassName DivideAndConquer_分治
 * @description:
 * @author: 许
 * @create: 2020-04-16 20:55
 * @Version 1.0
 **/

/**
 *
 *
 *
 */
public class DivideAndConquer_分治_汉诺塔 {

    public static void main(String[] args) {
        hanoiTower(3,'A','B','C');
    }

    public static void hanoiTower(int num,char a,char b ,char c){

        if(num == 1){
            System.out.println("第1个盘从 "+a+">"+c);
        }else{
            //看成两个盘
            //最上面的盘从A移到B
            hanoiTower(num-1,a,c,b);
            //最下面的盘从A移到C
            System.out.println("第"+num+"个盘从 "+a+">"+c);
            //再从B移到C
            hanoiTower(num-1,b,a,c);
        }
    }


}
