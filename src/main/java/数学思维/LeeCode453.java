package 数学思维;


import java.util.Arrays;

/**
 * 453. 最小操作次数使数组元素相等
 * LeeCode 453
 * 难度 ： 简单
 */
public class LeeCode453 {
    public static void main(String[] args) {
        int[] nums = {1,10000000,1};
        int i = minMoves(nums);
        System.out.println(i);
    }

    public static int minMoves(int[] nums) {
        //取得最小的值
        int asInt = Arrays.stream(nums).min().getAsInt();
        //根据数学算法得到所需的结果
        int m = 0;
        for (int num : nums) {
            m += num - asInt;
        }
        //返回结果
        return m;
    }
}
