package 暴力拆解;




/**
 *1480. 一维数组的动态和
 * LeeCode 1480
 * 难度 ： 中等
 */
public class LeeCode1480 {

    public int[] runningSum(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
            nums[i] = temp;
        }
        return nums;
    }
}
