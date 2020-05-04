package com.algorithm.example;

/**
 * @program: algorithm
 * @ClassName File
 * @description:
 * @author: 许
 * @create: 2020-04-13 21:25
 * @Version 1.0
 **/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *  中缀表达式 转 后缀表达式
 */
public class ZToH_中缀转后缀_栈 {
    static List<Object> sss = new ArrayList<Object>();
    public static void main(String[] args) {
//        String string = "1 + ( ( 2 + 30 ) * 4 ) - 5";
        String string = "50 + 6 - 45 * 5 + 1 - 10";
        List<String> list = getList(string);
        String hh = get(list);
        System.out.println(hh);
        for (int i = 0; i < sss.size(); i++) {
            System.out.printf("%s ",sss.get(i));
        }
    }
    public static List<String> getList(String suffiExpression){
        String[] strings = suffiExpression.split(" ");
        ArrayList arrayList = new ArrayList();

        for (String string : strings) {
            arrayList.add(string);
        }
        return arrayList;

    }
    public static String get(List<String> list){
        Stack s1 = new Stack();
        Stack s2 = new Stack();

        for (String s : list) {
            boolean flag = false;
            do{
                flag = false;
                if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")||s.equals("(")||s.equals(")")){
                    if (s1.empty() || s.equals("(")) {
                        s1.push(s);
                    }else if(s.equals(")")){
                        while(!s1.peek().equals("(")){
                            Object pop = s1.pop();
                            s2.push(pop);
                            sss.add(pop);
                        }
                        s1.pop();
                    }else{
                        //比较优先级
                        if (s1.peek().equals("(")) {
                            s1.push(s);
                        }else{
                            if (comparePrority(s) > comparePrority(s1.peek())) {
                                s1.push(s);
                            }else{
                                Object pop = s1.pop();
                                s2.push(pop);
                                sss.add(pop);
                                flag = true;
                            }
                        }
                    }
                }else{
                    sss.add(s);
                    if (s.length()>1) {
                        s = reverseString(s);
                    }
                    s2.push(s);
                }
            }while(flag);
        }
        while(!s1.empty()){
            Object pop = s1.pop();
            s2.push(pop);
            sss.add(pop);
        }
        StringBuffer stringBuffer = new StringBuffer();
        while(!s2.empty()){
            stringBuffer.append(s2.pop()+" ");
        }
        String string = stringBuffer.toString();

        return reverseString(string);
    }
    public static String reverseString(String s){
        if(s.length() == 1){
            return s;
        }
        String str1 = s.substring(s.length()-1);
        String str2 = reverseString(s.substring(0,s.length()-1));
        String str =  str1 + str2;
        return str;
    }
    public static int comparePrority(Object val){
        if(val.equals("+") || val.equals("-")){
            return 0;
        }else{
            return 1;
        }
    }
}
