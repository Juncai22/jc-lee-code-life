package 固定划窗;


/**
 * 剑指 Offer II 008. 和大于等于 target 的最短子数组
 * LeeCode 2566
 * 难度 ： 中等
 */
public class LeeCode2566 {


    public static void main(String[] args) {
        minSubArrayLen(7,
                new int[]{2, 3, 1, 2, 4, 3});
    }

    public static int minSubArrayLen(int target, int[] nums) {
        //左边界，右边界
        int left = 0;
        int right = 0;
        //因为求的是最小值，所以定一个很大的值
        int ans = 1000000000;
        //作为临时加数
        int temp = 0;
        //进行for循环
        for (int i = 0; i < nums.length; i++) {
            //每一个都相加，如果大于了，便开始减数
            temp += nums[i];
            right++;
            //如果大于，就开始减
            if (temp >= target) {
                ans = Math.min(ans, right - left);
                //while循环减
                while (temp >= target) {
                    temp -= nums[left];
                    left++;
                    if (temp >= target) {
                        ans = Math.min(ans, right - left);
                    }
                }
            }
        }
        //返回结果
        if (ans == 1000000000) return 0;
        return ans;
    }
}
