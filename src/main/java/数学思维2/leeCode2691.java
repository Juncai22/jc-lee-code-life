package 数学思维2;


import java.util.HashSet;

/**
 * 面试题 17.10. 主要元素
 * LeeCode 2691
 * 难度 ： 简单
 */
public class leeCode2691 {

    public static void main(String[] args) {
        int[] nums = {1,2,5,9,5,9,5,5,5};
        int i = majorityElement(nums);
        System.out.println(i);
    }

    public static int majorityElement(int[] nums) {
        //首先这里先选出包含最多的一个数字
        int candidate=0;
        int count=0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }
        //这里统计有多少个这样的数字，连最多的数字都没有，那么就是错的
        count=0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }
        if(count>nums.length/2){
            return candidate;
        }else{
            return -1;
        }
    }
}
