package 双指针;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 228. 汇总区间
 * LeeCode 228
 * 难度 ： 简单
 */
public class LeeCode228 {

    public static void main(String[] args) {
        int[] nums = {0,1,2,4,5,7};
        summaryRanges(nums);
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        //双指针
        int begin = 0, end = 0;
        for (int i = 0; i <= nums.length - 1; i++) {
            //首先进行初次赋值
            begin = nums[i];
            end = nums[i];
            //进行while循环，是否是连续的，如果连续那么就放入
            while (i + 1 <= nums.length - 1 && nums[i + 1] == nums[i] + 1) {;
                end = nums[++i];
            }
            if (begin == end) res.add(String.valueOf(end));
            else res.add(begin + "->" + end);
        }
        //返回
        return res;
    }
}
