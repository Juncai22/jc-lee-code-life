package 数学思维2;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 2420. 找到所有好下标
 * LeeCode 2420
 * 难度 ： 中等
 */
public class LeeCode2420 {

    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 1, 3, 4, 1};
        goodIndices(nums, 2);
    }

    public static List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        int count = 1;
        if (k == 1) {
            for (int i = 1; i < n - 1; i++) {
                res.add(i);
            }
            return res;
        }
        //进行单次循环并设计count，以此来计算答案
        for (int i = 1; i < n - k - 1; i++) {
            if (nums[i] <= nums[i - 1] && nums[i + k + 1] >= nums[i + k]) {
                count++;
                if (count >= k) {
                    //res.add答案
                    res.add(i + 1);
                }
            } else {
                count = 1;
            }
        }
        //返回答案
        return res;
    }
}
