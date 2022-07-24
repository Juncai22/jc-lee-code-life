package DP动态规划;


/**
 * 416. 分割等和子集
 * LeeCode 416
 * 难度 ： 中等
 */
public class LeeCode416TOCAHNGE {

    //方法一
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if (j >= num) {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][target];
    }


    //方法二
    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        //初筛
        if(sum % 2 == 1){
            return false;
        }
        //动态规划
        //背包容量
        int target = sum / 2;
        int[][] dp = new int[nums.length+1][target+1];
        //采用二维dp:物品是从第一个物品开始、背包也是从容量为1开始(0行、0列都已经初始化过了，所以前期dp数组无需再初始化了)
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                //注意这里为什么不是nums[i]呢？是因为nums索引与dp数组索引本身就差1
                // 这行代码的意思是：判断当前容量能不能容下当前物品
                if(j < nums[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-nums[i-1]]+nums[i-1]);
                }

            }
        }
        return dp[nums.length][target] == target;
    }
}
