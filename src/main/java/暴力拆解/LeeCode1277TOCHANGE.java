package 暴力拆解;



/**
 * 1277. 统计全为 1 的正方形子矩阵
 * LeeCode 1277
 * 难度 ： 中等
 */
public class LeeCode1277TOCHANGE {

    public int countSquares(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        int dp[][]=new int[row][col];
        int count=0;
        for(int i=0;i<row;i++){
            if(matrix[i][0]==1){
                dp[i][0]=1;
                count++;
            }
        }
        for(int j=1;j<col;j++){
            if(matrix[0][j]==1){
                dp[0][j]=1;
                count++;
            }
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(matrix[i][j]==1){
                    dp[i][j]=1;
                    if(dp[i-1][j]!=0&&dp[i][j-1]!=0&&dp[i-1][j-1]!=0){
                        dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                    }
                    count+=dp[i][j];
                }
            }
        }
        return count;
    }
}
