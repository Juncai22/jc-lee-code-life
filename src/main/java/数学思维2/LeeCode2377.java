package 数学思维2;


/**
 * LCP 06. 拿硬币
 * LeeCode 2377
 * 难度 ： 简单
 */
public class LeeCode2377 {

    public int minCount(int[] coins) {
        int ans = 0;
        for (int coin : coins) {
            ans += (coin + 1) / 2;
        }
        return ans;
    }
}
