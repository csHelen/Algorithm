package important;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @program: algorithm
 * @ClassName Greedy_贪心_集合覆盖
 * @description:
 * @author: 许
 * @create: 2020-04-17 06:27
 * @Version 1.0  (基本已独立完成)
 **/
public class Greedy_贪心_集合覆盖 {


    public static void main(String[] args) {
        HashMap<String,HashSet<String>> broadcast = new HashMap<String, HashSet<String>>();

        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        broadcast.put("k1",hashSet1);
        broadcast.put("k2",hashSet2);
        broadcast.put("k3",hashSet3);
        broadcast.put("k4",hashSet4);
        broadcast.put("k5",hashSet5);

        HashSet<String> allAreas = new HashSet<>();
        allAreas.add("大连");
        allAreas.add("杭州");
        allAreas.add("天津");
        allAreas.add("上海");
        allAreas.add("深圳");
        allAreas.add("北京");
        allAreas.add("成都");
        allAreas.add("广州");


        //存放选择的电台集合
        ArrayList<String> selects = new ArrayList<>();

        //临时集合，存放遍历过程中  电台覆盖的地区  和当前还没有覆盖的地区的交集
        HashSet<String> tempSet = new HashSet<>();

        //最大未覆盖的地区对应的电台的key
        String maxKey = null;

        //这个遍历过程会不断减少
        while(allAreas.size()!=0){
            maxKey = null;
            //取出所有key
            for (String key : broadcast.keySet()) {
                tempSet.clear();
                //获得当前key下的所有城市
                HashSet<String> areas = broadcast.get(key);
                //添加进去
                tempSet.addAll(areas);
                //tempSet 交  allArear
                tempSet.retainAll(allAreas);
                //如果当前 这个集合包含的微幅高地区的数量比maxKey指向的集合为覆盖的地区还多
                if (tempSet.size() > 0 && (maxKey == null || tempSet.size() > broadcast.get(maxKey).size())) {
                    maxKey = key;
                }



            }
            if (maxKey != null) {
                selects.add(maxKey);
                allAreas.removeAll(broadcast.get(maxKey));
            }
        }
        System.out.println(selects);

    }

}
