package 回溯;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 698. 划分为k个相等的子集
 * LeeCode 698
 * 难度 ： 中等
 */
public class LeeCode698TOCHANGE {


    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % k != 0)
            return false;
        int target = sum / k;
        int[] bucket = new int[k];
        return backtrack(nums, bucket, k, 0, target);
    }

    public boolean backtrack(int[] nums, int[] bucket, int k, int index, int target) {
        if (index == nums.length)
            return true;
        for (int i = 0; i < k; i++) {
            if (i > 0 && index == 0)
                continue;
            if (i > 0 && bucket[i] == bucket[i - 1])
                continue;
            if (bucket[i] + nums[index] > target)
                continue;
            bucket[i] += nums[index];
            if (backtrack(nums, bucket, k, index + 1, target))
                return true;
            bucket[i] -= nums[index];
        }
        return false;
    }
}
