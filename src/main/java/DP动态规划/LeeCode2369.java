package DP动态规划;


/**
 * 2369. 检查数组是否存在有效划分
 * LeeCode 2369
 * 难度 ： 中等
 */
public class LeeCode2369 {

    public static void main(String[] args) {
        int[] nums = {4,4, 4, 5, 6};
        validPartition(nums);
    }

    public static boolean validPartition(int[] nums) {
        int len = nums.length;
        // dp[i]表示第i位结尾是否可行
        boolean[] dp = new boolean[len];
        dp[0] = false;
        dp[1] = (nums[1] == nums[0]);
        for (int i = 2; i < len; i++) {
            // 按第一种分法
            if (nums[i] == nums[i - 1] && dp[i - 2]) {
                dp[i] = true;
            }
            // 按第二种分法
            if (nums[i] == nums[i - 2] && nums[i - 2] == nums[i - 1] && (i == 2 || dp[i - 3])) {
                dp[i] = true;
            }
            // 按第三种分法
            if (nums[i] == nums[i - 1] + 1 && nums[i] == nums[i - 2] + 2 && (i == 2 || dp[i - 3])) {
                dp[i] = true;
            }
        }
        return dp[len - 1];
    }
}
