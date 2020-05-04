package important;

/**
 * @program: algorithm
 * @ClassName KMP
 * @description:
 * @author: 许
 * @create: 2020-04-17 01:03
 * @Version 1.0
 **/

/**
 * 字符串匹配问题
 *      两个字符串，判断字符串A是否含有字符串B，如果有则返回第一次出现的文职，如果没有返回-1
 *
 *      KMP:
 *          利用之前判断过信息，通过next数组，保存模式串中前后最长公共子序列的长度
 *          每次回溯时，通过next数组找到，前面匹配过的位置，省去了大量的计算时间
 *
 *          步骤
 *              获得部分匹配表
 *
 */
public class KMP_字符串比较 {

    public static void main(String[] args) {
        System.out.println(KMPMatch("BBC_ABCDAE ABCDABCDABDE", "ABCDABD",kmpNext("ABCDABD")));
    }

    public static int KMPMatch(String str1,String str2,int[] next){
        for (int i = 0,j=0 ; i < str1.length(); i++) {

            //str1.charAt(i) != str2.charAt(j)，要去调整j
            while(j>0 && str1.charAt(i) != str2.charAt(j)){
                j = next[j-1];
            }

            if(str1.charAt(i) == str2.charAt(j)){
                j++;
            }
            if(j == str2.length()){
                return i - j + 1;
            }
        }
        return 0;
    }
    //获得一个字符串子串的部分匹配表
    public static int[] kmpNext(String dest){
        int[] next = new int[dest.length()];
        //如果IP字符串长度为1，部分匹配值一定为0
        next[0]=0;
        for (int i = 1,j=0; i < dest.length(); i++) {
            while(j>0 && dest.charAt(i) != dest.charAt(j)){
                j = next[j-1];
            }

            if (dest.charAt(i) == dest.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    //暴力破解，大量回溯，不可取
    public static int violenceMatch(String str1,String str2){
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        int s1Len = str1.length();
        int s2Len = str2.length();

        int s1 = 0;
        int s2 = 0;

        while(s1 < s1Len && s2 < s2Len){

            if(chars1[s1] == chars2[s2]){
                s1++;
                s2++;
            }else{
                s1 = s1 - (s2-1);
                s2 = 0;
            }
        }

        if(s2 == s2Len){
            return s1-s2;
        }else{
            return -1;
        }

    }
}
