package 数学思维2;


import java.util.Arrays;

/**
 * 2144. 打折购买糖果的最小开销
 * LeeCode 2144
 * 难度 ： 简单
 */
public class LeeCode2144 {
    public static void main(String[] args) {
        int[] cost = {1, 2, 3};
        minimumCost(cost);
    }

    public static int minimumCost(int[] cost) {
        int ans = 0;
        int m = cost.length;
        if (cost.length <= 2) {
            for (int i : cost) {
                ans += i;
            }
            return ans;
        }
        Arrays.sort(cost);

        while (m >= 3) {
            ans += cost[--m] + cost[--m];
            m--;
        }
        int i = cost.length % 3;
        if (i == 1) {
            ans += cost[0];
        } else if (i == 2) {
            ans += cost[0];
            ans += cost[1];
        }

        return ans;
    }
}
