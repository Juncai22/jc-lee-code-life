package 快速排序;


import java.util.Arrays;

/**
 * 剑指 Offer 40. 最小的k个数
 * LeeCode 2411
 * 难度 ： 简单
 */
public class LeeCode2411 {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1};
        int k = 2;
        int[] leastNumbers2 = getLeastNumbers2(arr, k);
        for (int i : leastNumbers2) {
            System.out.println(i);
        }
    }

    //第一种，直接Sort
    public static int[] getLeastNumbers(int[] arr, int k) {
        //直接Sort，然后得出结果
        int[] arrN = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            arrN[i] = arr[i];
        }
        return arrN;
    }

    //快速排序
    public static int[] getLeastNumbers2(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 最后一个参数表示我们要找的是下标为k-1的数
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private static int[] quickSearch(int[] nums, int lo, int hi, int k) {
        // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
        int j = partition(nums, lo, hi);
        if (j == k) {
            return Arrays.copyOf(nums, j + 1);
        }
        // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
        return j > k ? quickSearch(nums, lo, j - 1, k) : quickSearch(nums, j + 1, hi, k);
    }

    // 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。
    private static int partition(int[] nums, int lo, int hi) {
        int v = nums[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (++i <= hi && nums[i] < v) ;
            while (--j >= lo && nums[j] > v) ;
            if (i >= j) {
                break;
            }
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
        nums[lo] = nums[j];
        nums[j] = v;
        return j;

    }
}
