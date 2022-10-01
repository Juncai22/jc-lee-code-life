package 暴力拆解;


import java.util.Arrays;

/**
 * 1464. 数组中两元素的最大乘积
 * LeeCode 1464
 * 难度 ： 简单
 */
public class LeeCode1464 {


    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }
}
