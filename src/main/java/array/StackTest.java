package array;

/**
 * @program: algorithm
 * @ClassName StackTest
 * @description:
 * @author: 许
 * @create: 2020-04-13 13:24
 * @Version 1.0
 **/

import com.sun.deploy.util.StringUtils;

import java.util.Scanner;

/**
 * 栈 先进后出    数组模拟
 * 应用：
 *      二叉树遍历
 *      子程序的调用
 *      处理递归调用
 *      表达式的转换【中缀表达式转后缀表达式】与求值   !!!
 *      图形的深度优先搜索法
 */
public class StackTest {
    public static void testGUI(){
        ArrayStack arrayStack = new ArrayStack(4);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while(loop) {
            System.out.println("s(show):显示栈");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到栈");
            System.out.println("g(get):从栈取出数据");
            System.out.println("h(head):查看栈顶数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayStack.showStack();
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("请输入数字：");
                    int value = scanner.nextInt();
                    arrayStack.push(value);
                    break;
                case 'g':
                    arrayStack.pop();
                    break;
                case 'h':
                    arrayStack.head();
                    break;
            }
        }
    }

    public static void main(String[] args) {
        String express = "5*6+8+6-8-5+6/3";
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack signStack = new ArrayStack(10);
        int index = 0;
        Object num1;
        Object num2;
        Object oper;
        int res = 0;
        Object ch;
        String keepNum = "";
        while(true){
            ch = express.substring(index,index+1);
            if(signStack.isOper(ch)){
                if (signStack.isEmpty()) {
                    signStack.push(ch);
                }else{
                    //符号栈有值，要比较
                    // 当前操作符的优先级 <= 栈中的操作符   计算
                    if (signStack.priority(ch) <= signStack.priority(signStack.head())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = signStack.pop();
                        res = numStack.cal(num1,num2,oper);
                        numStack.push(res);
                        signStack.push(ch);
                    }else{
                        // 当前操作符的优先级 > 栈中的操作符  放入
                        signStack.push(ch);
                    }
                }
            }else{
                keepNum += ch;

                if(index == express.length() - 1){
                    numStack.push(keepNum);
                }else{
                    if(signStack.isOper(express.substring(index+1,index+2))){
                        numStack.push(keepNum);
                        keepNum = "";
                    }
                }
            }
            index++;
            if(index >= express.length()){
                break;
            }
        }
        while(true){
            if (signStack.isEmpty()) {
                //符号号为空，直接退出
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = signStack.pop();
            res = numStack.cal(num1,num2,oper);
            numStack.push(res);
        }
        System.out.println(express+"="+numStack.pop());

    }

    static class ArrayStack{
        int maxSize;
        Object[] stack;
        int top = -1;
        public ArrayStack(int max){
            maxSize = max;
            stack = new Object[maxSize];
        }
        public boolean isFull(){
            return top == maxSize-1;
        }
        public boolean isEmpty(){
            return top == -1;
        }
        public void push(Object num){
            if (isFull()) {
                System.out.println("栈满，无法放入数据");
                return;
            }
            top++;
            stack[top] = num;
        }
        public Object pop(){
            if (isEmpty()) {
                throw new RuntimeException("栈空，无法取触数据");
            }
            Object num = stack[top];
            top--;
            return num;
        }
        public Object head(){
            if (isEmpty()) {
                throw new RuntimeException("栈空，无法查看栈顶数据");
            }
            return stack[top];
        }
        public void showStack(){
            if (isEmpty()) {
                System.out.println("栈空，无法取触数据");
                return;
            }
            System.out.println("=======栈========");
            for (int i = top; i > -1; i--) {
                System.out.println(stack[i]);
            }
        }

        public int priority(Object oper){
            if(oper.equals("*") || oper.equals("/")){
                return 1;
            }else if(oper.equals("+") || oper.equals("-")){
                return 0;
            }else{
                return -1;
            }
        }

        public boolean isOper(Object val){
            return val.equals("+") ||  val.equals("-") || val.equals("/") || val.equals("*") ;
        }
        public int cal(Object num1,Object num2,Object oper){
            int res = 0;
            num1 = num1+"";
            num2 = num2+"";
            switch (oper.toString().charAt(0)){
                case '+':
                    res = Integer.parseInt((String)num2) + Integer.parseInt((String)num1);
                    break;
                case '-':
                    res =  Integer.parseInt((String)num2) - Integer.parseInt((String)num1);
                    break;
                case '*':
                    res = Integer.parseInt((String)num2) * Integer.parseInt((String)num1);
                    break;
                case '/':
                    res =  Integer.parseInt((String)num2) / Integer.parseInt((String)num1);
                    break;
                default:
                    break;
            }
            return res;
        }
    }
}
