package Hash表;


import java.util.HashMap;
import java.util.Map;

/**
 * 219. 存在重复元素 II
 * LeeCode 219
 * 难度 ： 简单
 */
public class LeeCode219 {

    //1.暴力解法
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i = 0;i<nums.length;i++) {
            for(int j = i+1;j<i+k+1&&j<nums.length;j++) {
                if(nums[j]==nums[i]) return true;
            }
        }
        return false;
    }

    //2.HashMap
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!numMap.containsKey(nums[i])) {
                numMap.put(nums[i], i);
            }else{
                if (Math.abs(numMap.get(nums[i]) - i) <= k){
                    return true;
                }else {
                    numMap.put(nums[i], i);
                }
            }
        }
        return false;
    }
}
