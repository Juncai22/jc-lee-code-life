package 固定划窗;


import java.util.Arrays;

/**
 * 1984. 学生分数的最小差值
 * LeeCode 1984
 * 难度 ： 简单
 */
public class LeeCode1984 {

    public int minimumDifference(int[] nums, int k) {
        if (k < 2) return 0;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE, bdry = k - 1;
        for (int i = nums.length - 1; i >= bdry; --i)
            //以k大小为固定划窗
            min = Math.min(min, nums[i] - nums[i - k + 1]);
        return min;
    }
}
