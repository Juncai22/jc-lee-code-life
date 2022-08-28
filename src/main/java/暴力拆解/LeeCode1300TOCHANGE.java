package 暴力拆解;


import java.util.Arrays;

/**
 * 1300. 转变数组后最接近目标值的数组和
 * LeeCode 1300
 * 难度 ： 简单
 */
public class LeeCode1300TOCHANGE {

    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int preSum[] = new int[arr.length + 3];
        for (int i = 1; i <= arr.length; i++) {
            preSum[i] = preSum[i - 1] + arr[i - 1];
        }
        int d = Math.abs(preSum[arr.length] - target), ans = arr[arr.length - 1], k = 0;
        for (int i = 0; i < arr[arr.length - 1]; i++) {
            while (arr[k] <= i) {
                k++;
            }
            int d1 = Math.abs(preSum[k] + i * (arr.length - k) - target);
            if (d1 < d || d == d1 && i < ans) {
                ans = i;
                d = d1;
            }
        }
        return ans;
    }
}
