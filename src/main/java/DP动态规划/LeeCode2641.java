package DP动态规划;


/**
 * 面试题 08.01. 三步问题
 * LeeCode 2641
 * 难度 ： 简单
 */
public class LeeCode2641 {

    public int waysToStep(int n) {
        //得到的直接取得数
        if(n <= 2) return n;
        if (n == 3) return 4;
        int[] d = new int[n + 1];

        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        for (int i = 4; i <= n; i++){
            //怕超出Int,取余
            d[i] = (d[i-1] + d[i-2]) % 1000000007 +d[i-3];
            d[i] %= 1000000007;
        }
        return d[n];
    }
}
