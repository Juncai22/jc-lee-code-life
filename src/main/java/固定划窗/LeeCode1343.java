package 固定划窗;


/**
 * 1343. 大小为 K 且平均值大于等于阈值的子数组数目
 * LeeCode 1343
 * 难度 ： 中等
 */
public class LeeCode1343 {

    public static void main(String[] args) {
        numOfSubarrays(new int[]{2, 2, 2, 2, 5, 5, 5, 8}, 3, 4);
    }


    //暴力解法
    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int temp = 0;
        int l = 0;
        int r = k - 1;
        for (int i = 0; i < k; i++) {
            temp += arr[i];
        }
        int ans = 0;
        for (int i = 0; i < arr.length - k && r + 1 < arr.length; i++) {
            if (temp >= threshold * k) {
                ans++;
            }
            temp -= arr[l++];
            temp += arr[++r];
        }
        if (temp >= threshold * k) {
            ans++;
        }
        return ans;
    }


    //前缀和  思路：1、前缀和数组快速计算子数组平均值 2、枚举每个子数组的左端点找到符合条件的子数组
    public int numOfSubarrays2(int[] arr, int k, int threshold) {
        int res = 0;
        int[] prefixSum = new int[arr.length + 1];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }
        for (int i = 0; i + k <= arr.length; i++) {
            if ((prefixSum[i + k] - prefixSum[i]) / k >= threshold) {
                res++;
            }
        }
        return res;
    }

    //固定划窗 思路：1、维护了一个固定窗口大小的滑动窗口 2、在不断滑动窗口的过程中更新窗口和
    public int numOfSubarrays3(int[] arr, int k, int threshold) {
        // 左端点
        int left = 0;
        // 右端点
        int right = left + k - 1;
        // 区间和
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += arr[i];
        }
        int res = 0;
        while (right + 1 < arr.length) {
            if (sum / k >= threshold) {
                res++;
            }
            // 窗口向右滑动一位
            sum -= arr[left++];
            sum += arr[++right];
        }
        if (sum / k >= threshold) {
            res++;
        }
        return res;
    }
}
