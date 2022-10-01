package Hash表;


import java.util.Arrays;
import java.util.HashMap;

/**
 * 2364. 统计坏数对的数目
 * LeeCode 2364
 * 难度 ： 中等
 */
public class LeeCode2364 {

    public static void main(String[] args) {
        int[] nums = {4, 1, 3, 3};
        countBadPairs(nums);
    }

    public static long countBadPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long count = 0;
        for(int i = 0; i < nums.length; i++){
            int prev = map.getOrDefault(i - nums[i], 0);
            count += i - prev;
            map.put(i - nums[i], prev + 1);
        }
        return count;
    }
}


