package 数学思维2;


/**
 * 189. 轮转数组
 * LeeCode 189
 * 难度 ： 中等
 */
public class LeeCode189 {

    public static void main(String[] args) {
        rotate(new int[]{1,2,3,4,5,6,7},3);
    }

    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        int[] ss = new int[2 * nums.length];
        for (int i = 0; i < ss.length; i++) {
            ss[i] = nums[i % nums.length];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = ss[i + nums.length - k];
        }
    }
}
