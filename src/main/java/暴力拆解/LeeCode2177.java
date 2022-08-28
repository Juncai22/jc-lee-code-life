package 暴力拆解;


import java.util.ArrayList;
import java.util.List;

/**
 * 2177. 找到和为给定整数的三个连续整数
 * LeeCode 2177
 * 难度 ： 中等
 */
public class LeeCode2177 {

    public long[] sumOfThree(long num) {
        long[] ans = new long[3];
        if (num % 3 != 0) {
            long[] cake = new long[0];
            return cake;
        } else {
            for (int i = 0; i < ans.length; i++) {
                ans[i] = num / 3 - 1 + i;
            }
        }
        return ans;
    }
}
