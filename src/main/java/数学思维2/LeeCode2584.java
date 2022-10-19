package 数学思维2;


/**
 * 剑指 Offer II 012. 左右两边子数组的和相等
 * LeeCode 2584
 * 难度 ： 简单
 */
public class LeeCode2584 {


    public int pivotIndex(int[] nums) {
        int sum = 0, cur = 0;

        for (int i : nums) sum += i;

        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
            if (cur == sum) return i;
            cur += nums[i];
        }
        return -1;
    }
}
