package 数学思维2;


/**
 * 1646. 获取生成数组中的最大值
 * LeeCode 1646
 * 难度 ： 简单
 */
public class LeeCode1646 {


    public int getMaximumGenerated(int n) {
        if (n == 0 || n == 1) return n;
        int[] num = new int[n + 1];
        num[0] = 0;
        num[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) num[i] = num[i / 2];
            else num[i] = num[i / 2] + num[(i + 1) / 2];
        }
        int ans = 0;
        for (int i : num) {
            ans = Math.max(ans, i);
        }
        return ans;
    }
}
