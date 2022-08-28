package 数学思维2;


/**
 * 1872. 石子游戏 VIII
 * LeeCode 1872
 * 难度 ： 困难
 */
public class LeeCode1872TOCHANGE {


    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        // 求出前缀和。prefix[i + 1] 表示 [0: i] 区间的区间和。每一次取石头的过程其实就是选择一个下标 x，将 [0, x] 合并成一堆，并将 prefix[x + 1] 作为本轮的得分。
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++)
            prefix[i] = prefix[i - 1] + stones[i - 1];
        // dp[i] 表示当可选择下标 [i: n) 个石头时的分差：如果选择的是下标 i，则当前选手获得 prefix[i + 1]，对手在 [i + 1: n) 的石头内继续，得分差为 dp[i + 1]，则对当前选手而言得分差为 prefix[i + 1] - dp[i + 1]；如果不选择下标 i，则会在 [i + 1, n) 内做选择，dp[i] = dp[i + 1]。取两种情况的最大值作为 dp[i]，转移方程为：dp[i] = max(prefix[i + 1] - dp[i + 1], dp[i + 1])，观察到 dp[i] 只转移自 dp[i + 1]，可以只设立一个变量 dp 表示当前的得分差。
        int dp = prefix[n];
        for (int i = n - 2; i > 0; i--)
            dp = Math.max(prefix[i + 1] - dp, dp);
        return dp;
    }
}
