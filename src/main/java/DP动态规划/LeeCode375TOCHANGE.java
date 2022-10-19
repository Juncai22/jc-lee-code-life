package DP动态规划;


/**
 * 375. 猜数字大小 II
 * LeeCode 375
 * 难度 ： 中等
 */
public class LeeCode375TOCHANGE {

    public static void main(String[] args) {
        getMoneyAmount(10);
    }

    public static int getMoneyAmount(int n) {
        int[][] f = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j <= n; j++) {
                f[i][j] = j + f[i][j - 1];
                for (int k = i; k < j; k++) {
                    f[i][j] = Math.min(f[i][j], k + Math.max(f[i][k - 1], f[k + 1][j]));
                }
            }
        }
        return f[1][n];
    }
}
