package 数学思维;


import java.util.*;

/**
 * 1636. 按照频率将数组升序排序
 * LeeCode 1636
 * 难度 ： 简单
 */
public class LeeCode1636 {


    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> resMap = new HashMap<>();
        List<Integer> numsList = new ArrayList<>();
        //统计次数
        for (int curr : nums) {
            numsList.add(curr);
            resMap.put(curr, resMap.getOrDefault(curr, 0) + 1);
        }
        //按规则排序
        numsList.sort((a,b) -> {
            int aCount = resMap.get(a);
            int bCount = resMap.get(b);
            if (aCount == bCount) {
                return b - a;
            }
            return aCount - bCount;
        });
        return numsList.stream().mapToInt(Integer::intValue).toArray();
    }
}
