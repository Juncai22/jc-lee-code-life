package 数学思维;


/**
 * 面试题 17.04. 消失的数字
 * LeeCode 2672
 * 难度 ： 简单
 */

public class LeeCode2672 {

    //总长度减去小长度
    public int missingNumber(int[] nums) {
        int m = nums.length;
        int k = m*(m+1)/2;
        for (int num : nums) {
            k -= num;
        }
        return k;

    }
}
