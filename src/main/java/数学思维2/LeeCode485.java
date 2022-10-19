package 数学思维2;


/**
 * 485. 最大连续 1 的个数
 * LeeCode 485
 * 难度 ： 简单
 */
public class LeeCode485 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int l = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 1) {
                max = Math.max(max, i - l);
                l = i + 1;
            }
        }
        return Math.max(max, nums.length - l);
    }
}
