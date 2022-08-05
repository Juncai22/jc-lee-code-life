package 数学思维2;


import java.util.Arrays;

/**
 * 1005. K 次取反后最大化的数组和
 * LeeCode 1005
 * 难度 ： 简单
 */
public class LeeCode1005 {

    public int largestSumAfterKNegations(int[] nums, int k) {
        //先进行sort
        Arrays.sort(nums);

        //然后单次for循环
        for (int i = 0; i < nums.length; i++) {
            //当k==0，直接结束
            if (k == 0){
                break;
            }
            //将小于0的直接变为正数
            if (nums[i] < 0){
                nums[i] = -nums[i];
                k--;
            }else{
                if (nums[i] >= 0){
                    break;
                }
            }
        }

        //再次进行sort，如果k有多的
        Arrays.sort(nums);
        //那么将最小的反转
        if (k % 2 == 1) nums[0] *= -1;

        int ans = 0;
        //让num的各个数字相加
        for (int num : nums) {
            ans += num;
        }
        return ans;
    }
}
