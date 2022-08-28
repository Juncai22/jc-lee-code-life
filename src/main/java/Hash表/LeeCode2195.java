package Hash表;


import java.util.*;

/**
 * 2195. 向数组中追加 K 个整数
 * LeeCode 2195
 * 难度 ： 中等
 */
public class LeeCode2195 {

    public static void main(String[] args) {
        int[] nums = {1, 4, 25, 10, 25};
        int k = 2;
        minimalKSum(nums, k);
    }

    public static long minimalKSum(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) set.add(num);

        long res = (1L + k) * k / 2;
        int next = k + 1;
        // 通过遍历 set 去除了(nums[i-1] == nums[i])的情况
        for (int num : set) {
            if (num <= k) {
                while (set.contains(next)) {
                    next++;
                }
                res = res - num + next;
                next++;
            }
        }

        return res;
    }
}
