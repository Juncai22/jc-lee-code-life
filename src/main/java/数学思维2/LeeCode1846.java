package 数学思维2;


import java.util.Arrays;

/**
 * 1846. 减小和重新排列数组后的最大元素
 * LeeCode 1846
 * 难度 ： 中等
 */
public class LeeCode1846 {


    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] > 1 + arr[i]) {
                arr[i + 1] = arr[i] + 1;
            }
        }
        return arr[arr.length - 1];
    }
}
