package 竞赛题.第308场周赛;


import java.util.Arrays;

/**
 * 6160. 和有限的最长子序列
 * LeeCode 6160
 * 难度 ： 简单
 */
public class LeeCodeJINGSAI6160 {

    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 1};
        int[] queries = {3, 10, 21};
        answerQueries(nums, queries);
    }

    public static int[] answerQueries(int[] nums, int[] queries) {
        int[] ans = new int[queries.length];
        int n = 0;
        Arrays.sort(nums);
        while (n <= queries.length - 1) {
            int temp = 0;
            for (int i = 0; i < nums.length; i++) {
                temp += nums[i];
                if (temp > queries[n]) {
                    ans[n] = i;
                    break;
                } else if (i == nums.length - 1 && temp <= queries[n]) {
                    ans[n] = nums.length;
                }
            }
            n++;
        }
        return ans;
    }
}
