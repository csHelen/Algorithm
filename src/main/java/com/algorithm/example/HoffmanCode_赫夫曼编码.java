package com.algorithm.example;

/**
 * @program: algorithm
 * @ClassName HoffmanCode_赫夫曼编码
 * @description:
 * @author: 许
 * @create: 2020-04-15 16:58
 * @Version 1.0
 **/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * *      赫夫曼编码：
 *  *          电讯通信中经典的应用之一
 *  *          广泛用于数据文件压缩，压缩率通常在 20% ~ 90%之间
 *  *          是可变字长编码VLC的一种，最佳编码
 */
public class HoffmanCode_赫夫曼编码 {
    public static StringBuilder stringBuilder = new StringBuilder();
    public static Map<Byte,String> huffmanCode = new HashMap<>();
    public static Map<String,String> huffmanCodeReverse = new HashMap<>();

    public static void main(String[] args) {
        String string = "i like like like java do you like a java";
        System.out.println("未转化前：");
        System.out.println(string);

        byte[] bytes = string.getBytes();
        List<CNode> nodes = get(bytes);

        //获得赫夫曼树
        CNode huffmanTre = createHuffmanTre(nodes);

        //获得赫夫曼编码
        getCodes(huffmanTre,"",stringBuilder);

        System.out.println("转换对照maps");
        System.out.println(huffmanCode);
//        System.out.println("反转对照maps");
//        System.out.println(huffmanCodeReverse);


        System.out.println("转化成赫夫曼编码");
        String s = tuHuffman(string, huffmanCode);
        System.out.println(s);
//        System.out.println("转化成人类可识别文字");
//        String strFromHuffman = getStrFromHuffman(s, huffmanCodeReverse);
//        System.out.println(strFromHuffman);


    }

    /**
     *
     * @param bytes     "i like ..."对应的byte[]
     * @param huffmanCodes  转换的赫夫曼编码map
     *
     * @return  赫夫曼编码处理后的 byte[]
     *  过程：
     *      通过byte[]和map得到字符串
     *      ↓  133个  ↓
     *      1010100010111111110010001011111111001000101111111100100101001101110001110000011011101000111100101000101111111100110001001010011011100
     *      取前八位 huffmanCodeBytes[0] = 10101000(补码)
     *          => byte[推到 10101000 => 10101000-1 = 10100111(反码) => 11011000(原码) = -(8+16+64)=-88]
     *
     */
//    public static byte[] zip(byte[] bytes,Map<Byte,String> huffmanCodes){
//
//    }


    public static String getStrFromHuffman(String str,Map<String,String> maps){
        String temp;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < str.length(); i++) {
            temp = str.substring(0,i);
            String get = maps.get(temp);
            if (get != null) {
                //找到的话
                //提取解码信息
                sb.append((char)Integer.parseInt(get));
                //替换查找的字符串
                str = str.substring(i);
                //i恢复成1
                i = 1;
            }
        }
        return sb.toString();
    }

    public static String tuHuffman(String str,Map<Byte,String> maps){
        byte[] bytes = str.getBytes();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String s = maps.get(bytes[i]);
            temp.append(maps.get(bytes[i]));
        }
        return temp.toString();
    }

    /**
     * @param node
     * @param code  左为0，右为1
     * @param stringBuilder
     */
    public static void getCodes(CNode node,String code,StringBuilder stringBuilder){
        StringBuilder builder = new StringBuilder(stringBuilder);
        builder.append(code);
        if (node!=null) {
            //判断是叶子还是非叶子
            if(node.data == null){
                //非叶子节点
                //向左递归
                getCodes(node.left,"0",builder);

                //向右递归
                getCodes(node.right,"1",builder);
            }else{
                //说明是叶子节点
                huffmanCode.put(node.data,builder.toString());
                huffmanCodeReverse.put(builder.toString(),node.data.toString());
            }
        }

    }

    public static CNode createHuffmanTre(List<CNode> list){
        while(true){
            if(list.size()==1){
                break;
            }
            //取出最小的两个结点
            CNode left = list.get(0);
            CNode right = list.get(1);

            CNode parent = new CNode(null,left.weight+right.weight);
            parent.left = left;
            parent.right = right;

            list.remove(0);
            list.remove(0);
            list.add(parent);
            //排序
            list.sort((n1,n2) -> n1.weight - n2.weight);
        }
        return list.get(0);

    }

    public static List<CNode> get(byte[] bytes){
        ArrayList<CNode> nodes = new ArrayList<>();
        Byte temp;
        Map<Byte,Integer> maps = new HashMap<>();
        for (int i = 0; i < bytes.length; i++) {
            temp = bytes[i];
            Integer count = maps.get(temp);
            if (count !=null) {
                maps.put(temp,count+1);
            }else{
                maps.put(temp,1);
            }
        }
        for(Map.Entry<Byte,Integer> entry : maps.entrySet()){
            nodes.add(new CNode(entry.getKey(),entry.getValue()));
        }
        nodes.sort((n1,n2) -> n1.weight - n2.weight);
        return nodes;
    }

}
class CNode{
    Byte data;  //存数据，'a' => 97   ' ' => 32
    int weight; //出现次数
    CNode left;
    CNode right;

    @Override
    public String toString() {
        return "cNode{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    public CNode(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    public void preOrder(){
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }
}