package 数学思维2;


/**
 * 724. 寻找数组的中心下标
 * LeeCode 724
 * 难度 ： 简单
 */
public class LeeCode724 {

    public static void main(String[] args) {
        int[] nums = {-1, -1, -1, -1, -1, 0};
        pivotIndex(nums);
    }

    public static int pivotIndex(int[] nums) {
        int right = 0;
        int left = 0;
        for (int num : nums) right += num;
        for (int i = 0; i < nums.length; i++) {
            right -= nums[i];
            if (right == left) return i;
            left += nums[i];
        }
        return -1;
    }
}
