package 数学思维2;


/**
 * 80. 删除有序数组中的重复项 II
 * LeeCode 80
 * 难度 ： 中等
 */
public class LeeCode80 {

    public static void main(String[] args) {
        int[] nusm = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        removeDuplicates(nusm);
        for (int i = 0; i < nusm.length; i++) {
            System.out.println(nusm[i]);
        }
    }

    public static int removeDuplicates(int[] nums) {
        int t = 0;
        int t0 = 0;
        for (int i = 2; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int temp = nums[j - t0];
                nums[j - t0] = nums[j];
                nums[j] = temp;
            }
            if (t0 > 0) {
                t0--;
                i--;
            }
            if (nums[i] == nums[i - 1] && nums[i - 1] == nums[i - 2]) {
                t++;
                t0++;
                nums[i] = -100000 - t;
            }
        }
        return nums.length - t;
    }
}
