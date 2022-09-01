package 数学思维2;


/**
 * 1470. 重新排列数组
 * LeeCode 1470
 * 难度 ： 简单
 */
public class LeeCode1470 {


    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        int t = 0;
        for (int i = 0; i < 2 * n; i++) {
            ans[i] = nums[t];
            ans[++i] = nums[t + n];
            t++;
        }
        return ans;
    }
}
