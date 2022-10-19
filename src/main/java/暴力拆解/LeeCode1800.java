package 暴力拆解;


/**
 * 1800. 最大升序子数组和
 * LeeCode 1800
 * 难度 ： 简单
 */
public class LeeCode1800 {


    public int maxAscendingSum(int[] nums) {
        int ans = 0, sum = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
