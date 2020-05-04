package important;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @program: algorithm
 * @ClassName GreedyTest
 * @description:
 * @author: 许
 * @create: 2020-04-17 08:38
 * @Version 1.0
 **/
public class GreedyTest {


    public static void main(String[] args) {
        HashMap<String, HashSet<String>> broadcast = new HashMap<String, HashSet<String>>();

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

        //表示能够覆盖地区最多的广播台
        String maxKey = null;
        Integer max = null;
        //新建临时存储
        HashSet<String> value = null;

        //结果集
        ArrayList<String> result = new ArrayList();

        while (allAreas.size() != 0) {
            maxKey = null;
            max = null;
            for(String key : broadcast.keySet()){
                //找到key对应的覆盖地区
                value = broadcast.get(key);
                //得到实际可以覆盖地区个数
                value.retainAll(allAreas);

                if(max ==  null || max < value.size()){
                    max = value.size();
                    maxKey = key;
                }
            }
            result.add(maxKey);
            allAreas.removeAll(broadcast.get(maxKey));
        }

        System.out.println(result);



    }
}
