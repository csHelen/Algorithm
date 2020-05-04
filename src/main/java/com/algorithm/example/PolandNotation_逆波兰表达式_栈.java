package com.algorithm.example;

/**
 * @program: algorithm
 * @ClassName PolandNotation
 * @description:
 * @author: 许
 * @create: 2020-04-13 20:33
 * @Version 1.0
 **/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 */
public class PolandNotation_逆波兰表达式_栈 {
    /**
     *
     *  我们经常书写的算术 （3+4） x 5-6   成为中缀表达式
     *  由此转成前缀表达式    - x + 3 4 5 6
     *          从 右 向 左 扫描
     *              1、   6 5 4 3 先压入栈
     *              2、   遇到 + ，取出栈顶两元素 3 和 4
     *              3、     3  +  4  =  7  入栈
     *              此时 栈情况：     7  5 6
     *              4、   遇到  *  ，取出栈顶两元素  7 和 5
     *              5、     7  *  5  =  35  入栈
     *              此时 栈情况：    35  6
     *              6、   遇到  -  ，取出栈顶两元素  35 - 6   （先出站35 符号- 后出站6）的 29
     *
     *  那转成后缀表达式     3 4 + 5 x 6 -
     *          从 左 向 右 扫描
     *              1、  3  4  压入栈 看到 +  直接运算 3 + 4  = 7 压入栈
     *              此时栈情况  7
     *              2、  将 5 压入栈  看到 *  直接运算  7*5 = 35 压入栈
     *              此时栈情况  35
     *              3、   将6压入栈   看到 -   直接运算 35-6 = 29
     *
     *
     */

    public static void main(String[] args) {
        testCalPolandNotation();
    }

    public static void testCalPolandNotation(){
        String suffiExpression = "4 5 * 8 - 60 + 8 2 / +";
        List<String> list = getList(suffiExpression);
        int cal = cal(list);
        System.out.println(suffiExpression+"==="+cal);
    }
    public static List<String> getList(String suffiExpression){
        String[] strings = suffiExpression.split(" ");
        ArrayList arrayList = new ArrayList();
        for (String string : strings) {
            arrayList.add(string);
        }
        return arrayList;
    }
    public static int cal(List<String> list){
        Stack stack = new Stack();
        for (String s : list) {
            if(s.equals("+") || s.equals("*") || s.equals("/") ||s.equals("-") ){
                Integer num1 = Integer.parseInt(stack.pop().toString());
                Integer num2 = Integer.parseInt(stack.pop().toString());;
                int result = 0;
                switch (s.toString().charAt(0)){
                    case '+':
                        result = num2 + num1;
                        break;
                    case '-':
                        result = num2 - num1;
                        break;
                    case '*':
                        result = num2 * num1;
                        break;
                    case '/':
                        result = num2 / num1;
                        break;
                }
                stack.push(result);
            }else{
                stack.push(s);
            }
        }
        return Integer.parseInt(stack.pop().toString());
    }
}
