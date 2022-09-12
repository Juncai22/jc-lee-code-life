package 固定划窗;


/**
 * 2134. 最少交换次数来组合所有的 1 II
 * LeeCode 2134
 * 难度 ： 自动
 */
public class LeeCode2134 {

    public static void main(String[] args) {
        System.out.println(args[0]);
    }

    public static int minSwaps(int[] nums) {
        int count = 0, ans = 0, num = 0;//分别用来记录数组内1总数、滑窗内1最大数、以及现在滑窗内1个数
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
        }
        //此时确定滑窗大小为count
        for (int i = 0; i < count; i++) {
            num += nums[i];
        }
        ans = num;
        for (int i = 0; i < nums.length - 1; i++) {
            num += nums[(count + i) % nums.length] - nums[i];
            ans = Math.max(ans, num);
        }
        return count - ans;
    }

}
