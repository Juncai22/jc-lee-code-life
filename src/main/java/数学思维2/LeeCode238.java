package 数学思维2;


/**
 * 238. 除自身以外数组的乘积
 * LeeCode 238
 * 难度 ： 中等
 */
public class LeeCode238 {

    public int[] productExceptSelf(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int len = nums.length;
        int[] res = new int[len];

        int left = 1;
        for (int i = 0; i < len; i++) {
            // 防止越界
            if (i > 0) {
                left = left * nums[i - 1];
            }
            res[i] = left;
        }

        int right = 1;
        for (int i = len - 1; i >= 0; i--) {
            // 防止越界
            if (i < len - 1) {
                right = right * nums[i + 1];
            }
            res[i] *= right;
        }

        return res;

    }
}
