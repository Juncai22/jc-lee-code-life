package DP动态规划;


/**
 * 63. 不同路径 II
 * LeeCode 63
 * 难度 ： 中等
 */
public class LeeCode663 {

    public static void main(String[] args) {
        int[][] test = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        uniquePathsWithObstacles(test);
    }


    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //设置长度，并且选定长度
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        //进行简单dp
        int[][] f = new int[m][n];
        int flag = 1;
        //进行初次初始化
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) flag = 0;
            f[i][0] = flag;
        }
        flag = 1;
        //进行第二次初始化
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) flag = 0;
            f[0][i] = flag;
        }
        //进行dp
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) f[i][j] = f[i - 1][j] + f[i][j - 1];
                else f[i][j] = 0;
            }
        }
        return f[m - 1][n - 1];
    }
}
