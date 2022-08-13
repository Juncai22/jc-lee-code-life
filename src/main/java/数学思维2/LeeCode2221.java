package 数学思维2;


/**
 * 2221. 数组的三角和
 * LeeCode 2221
 * 难度 ： 中等
 */
public class LeeCode2221 {

    public int triangularSum(int[] nums) {
        int size = nums.length - 1;
        while (size != 0) {
            for (int i = 0; i < size; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
            size--;
        }
        return nums[0];
    }
}
