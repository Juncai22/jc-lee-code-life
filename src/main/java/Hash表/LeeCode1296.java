package Hash表;


import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * 1296. 划分数组为连续数字的集合
 * LeeCode 1296
 * 难度 ： 中等
 */
public class LeeCode1296 {


    public boolean isPossibleDivide(int[] nums, int k) {
        //首先定义一个可排序的map
        TreeMap<Integer, Integer> map = new TreeMap<>();
        //并将各种数字加起来
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //循环遍历，如果刚刚好那就是true，不是刚刚好，就是false
        while (map.size() > 0) {
            int first = map.firstKey();
            for (int i = first; i < first + k; i++) {
                if (!map.containsKey(i)) return false;
                map.put(i, map.get(i) - 1);
                //当个数为0时，便返回
                if (map.get(i) == 0) {
                    map.remove(i);
                }
            }
        }
        return true;
    }
}
