package DP动态规划;


import static java.lang.Math.max;

/**
 * 978. 最长湍流子数组
 * LeeCode 978
 * 难度 ： 中等
 */
public class LeeCode978 {

    public static void main(String[] args) {
        int[] arr = {9,4,2,10,7,8,8,1,9};
        maxTurbulenceSize(arr);
    }

    public static int maxTurbulenceSize(int[] arr) {
        int ret = 1;
        int n = arr.length;
        int dp0 = 1, dp1 = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] > arr[i]) {
                dp0 = dp1 + 1;
                dp1 = 1;
            } else if (arr[i - 1] < arr[i]) {
                dp1 = dp0 + 1;
                dp0 = 1;
            } else {
                dp0 = 1;
                dp1 = 1;
            }
            ret = Math.max(ret, dp0);
            ret = Math.max(ret, dp1);
        }
        return ret;
    }

}
