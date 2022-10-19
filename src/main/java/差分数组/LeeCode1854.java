package 差分数组;



/**
 * 1854. 人口最多的年份
 * LeeCode 1854
 * 难度 ： 简单
 */
public class LeeCode1854 {


    public int maximumPopulation(int[][] logs) {
        int[] ints = new int[101];
        int ans = 0,max = 0,temp = 0;

        for (int[] log : logs) {
            ints[log[0] - 1950]++;
            ints[log[1] - 1950]--;
        }

        for (int i = 0; i < ints.length; i++) {
            temp += ints[i];
            if (temp > max) {
                max = temp;
                ans = i;
            }
        }

        return ans + 1950;
    }
}
