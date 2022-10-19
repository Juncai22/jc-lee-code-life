package 前缀和;


import java.util.Arrays;

/**
 * 1191. K 次串联后最大子数组之和
 * LeeCode 1191
 * 难度 ： 中等
 */
public class LeeCode1191TOCHANGE {


    //动态规划超过内存长度
    public int kConcatenationMaxSum(int[] arr, int k) {
        int mod = 1000000007;
        long preSum = 0, preMax = 0, sufSum = 0, sufMax = 0, curSum = 0, curMax = 0;
        for (int i = 0; i < arr.length; i++) {
            preSum += arr[i];//前缀和
            preMax = Math.max(preMax, preSum);//最大前缀和
            sufSum += arr[arr.length - 1 - i];//后缀和
            sufMax = Math.max(sufSum, sufMax);//最大后缀和
            curSum = arr[i] + Math.max(0, curSum);//求和最大连续子数组
            curMax = Math.max(curSum, curMax);
        }
        //最大串联连续和为：前缀加后缀的最大值加上连续的串联或者不串联的最大连续和
        return k == 1 ? (int)curMax :
                (int)(Math.max(curMax, (preMax + sufMax + Math.max(0, preSum) * (k - 2))) % mod);
    }
}
