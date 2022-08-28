package 二分查找法;


import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 1608. 特殊数组的特征值
 * LeeCode 1608
 * 难度 ： 简单
 */
public class LeeCode1608 {

    public int specialArray(int[] nums) {
        int left = 1, right = nums.length, ans = 0;
        while (left <= right) {
            int y = (left + right) / 2, count = 0;
            for (int i : nums) {
                if (i >= y) {
                    count++;
                }
            }
            if (count == y)
                return y;
            if (count >= y) {
                left = y + 1;
            } else {
                right = y;
            }

        }
        return -1;
    }
}
