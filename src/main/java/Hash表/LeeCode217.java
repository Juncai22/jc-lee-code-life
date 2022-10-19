package Hash表;


import java.util.HashSet;

/**
 * 217. 存在重复元素
 * LeeCode 217
 * 难度 ： 简单
 */
public class LeeCode217 {


    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return true;
            else set.add(num);
        }
        return false;
    }
}
