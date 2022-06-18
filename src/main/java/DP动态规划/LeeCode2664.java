package DP动态规划;


/**
 * 面试题 17.16. 按摩师
 * LeeCode 2664
 * 难度 ： 简单
 */
public class LeeCode2664 {
    public static void main(String[] args) {
        int[] nums = {2,1,4,5,3,1,1,3};
        int massage = massage(nums);
        System.out.println(massage);
    }


    public static int massage(int[] nums) {
        //first是前面一个初态，以它为基础，来判断是否前进和后退
        int first=0;
        //实际值，根据first+i后的值来进行判断。
        int second=0;
        //循环遍历，然后判断是否前进，后退
        for(int i:nums){
            int temp=second;
            second=Math.max(second,first+i);
            first=temp;
        }
        //返回结果
        return second;
    }

}
