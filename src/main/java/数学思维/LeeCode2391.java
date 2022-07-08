package 数学思维;


import java.util.Arrays;

/**
 * LCS 02. 完成一半题目
 * LeeCode 2391
 * 难度 ： 简单
 */
public class LeeCode2391 {

    public int halfQuestions(int[] questions) {
        // 初始哈希表
        int[] nums = new int[1001];
        for (int x:questions) nums[x]++;
        // 数量和
        int sum = 0;
        // 知识点
        int count = 0;
        // 排序
        Arrays.sort(nums);
        for (int i = nums.length-1; i >= 0; i--) {
            sum += nums[i];
            count++;
            // 当此时的数量和超过问题数/2
            if (sum >= questions.length/2) break;
        }
        return count;
    }
}
