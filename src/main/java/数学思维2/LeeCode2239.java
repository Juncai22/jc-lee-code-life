package 数学思维2;


/**
 * 2239. 找到最接近 0 的数字
 * LeeCode 2239
 * 难度 ： 简单
 */
public class LeeCode2239 {

    public static void main(String[] args) {
        int[] nums = {2, -1, 1};
        findClosestNumber(nums);
    }

    public static int findClosestNumber(int[] nums) {
        int ans = 100000000;
        int ans1 = 0;
        int ak = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] = -nums[i];
                ak = 1;
            } else {
                ak = 0;
            }
            if (ans > nums[i]) {
                ans = nums[i];
                if (ak == 1) ans1 = -ans;
                else ans1 = ans;
            } else if (ans == nums[i]) {
                if (ak == 0) ans1 = Math.max(ans1, nums[i]);
                else ans1 = Math.max(ans1, -nums[i]);
            }

        }
        return ans1;
    }
}
