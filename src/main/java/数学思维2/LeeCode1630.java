package 数学思维2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1630. 等差子数组
 * LeeCode 1630
 * 难度 ： 中等
 */
public class LeeCode1630 {

    public static void main(String[] args) {
        int[] nums = {4, 6, 5, 9, 3, 7};
        int[] l = {0, 0, 2};
        int[] r = {2, 3, 5};
        checkArithmeticSubarrays(nums, l, r);
    }

    public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        //首先定义答案
        List<Boolean> list = new ArrayList<>();
        //定义一个基本指针
        int t = 0;
        //进行l，r指针循环
        for (int i = 0; i < l.length; i++, t++) {
            double temp = 0;
            //使用方法截断需要用的数组
            int[] chance = chance(nums, l[t], r[t]);
            //进行排序
            Arrays.sort(chance);
            //进行一次fdr循环，来看是否是等差数列
            for (int j = 0; j < chance.length - 1; j++) {
                temp = (chance[chance.length - 1] - chance[0]) / (r[t] - l[t]);
                //要是有一次不是，则返回false
                if (chance[j + 1] - chance[j] != temp) {
                    list.add(false);
                    break;
                }
                //若是，返回true
                if (j == chance.length - 2) list.add(true);
            }
        }
        return list;
    }

    //定义的截断方法
    public static int[] chance(int[] shu, int begin, int end) {
        int[] ans = new int[end - begin + 1];
        int x = 0;
        for (int i = begin; i < end + 1; i++, x++) {
            ans[x] = shu[i];
        }
        return ans;
    }
}
