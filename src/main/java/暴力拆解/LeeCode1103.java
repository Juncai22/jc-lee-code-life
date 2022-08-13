package 暴力拆解;


/**
 * 1103. 分糖果 II
 * LeeCode 1103
 * 难度 ： 简单
 */
public class LeeCode1103 {

    public static void main(String[] args) {
        distributeCandies(60,4);
    }

    public static int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        int num = 0;
        int times = 0;
        while (num < candies) {
            for (int i = 0; i < ans.length; i++) {
                if (candies - num < times * num_people + i + 1) {
                    ans[i] += candies - num;
                    return ans;
                }
                ans[i] += times * num_people + i + 1;
                num += times * num_people + i + 1;
            }
            times++;
        }
        return ans;
    }
}
