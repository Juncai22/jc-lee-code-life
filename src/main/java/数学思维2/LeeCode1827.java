package 数学思维2;


/**
 * 1827. 最少操作使数组递增
 * LeeCode 1827
 * 难度 ： 简单
 */
public class LeeCode1827 {

    public int minOperations(int[] nums) {
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] >= nums[i]){
                ans += nums[i - 1] - nums[i] + 1;
                nums[i] = nums[i - 1] + 1;
            }
        }
        return ans;
    }
}
