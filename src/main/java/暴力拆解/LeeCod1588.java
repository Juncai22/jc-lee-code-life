package 暴力拆解;


/**
 * 1588. 所有奇数长度子数组的和
 * LeeCode 1588
 * 难度 ： 简单
 */
public class LeeCod1588 {

    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        int len = arr.length;
        int gap = 1;
        do {
            for (int i = 0; i <= len - gap; ++i) {
                for (int j = i; j < i + gap; ++j) {
                    sum += arr[j];
                }
            }
        } while ((gap += 2) <= len);
        return sum;
    }
}
