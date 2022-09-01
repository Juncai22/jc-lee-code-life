package 临时时间段;


/**
 * 1475. 商品折扣后的最终价格
 * LeeCode 1475
 * 难度 ： 简单
 */
public class LeeCode1475 {

    public static void main(String[] args) {
        int[] prices = {8, 4, 6, 2, 3};
        finalPrices(prices);
    }

    public static int[] finalPrices(int[] prices) {
        int[] ans = new int[prices.length];
        ans[prices.length - 1] = prices[prices.length - 1];
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] >= prices[j]) {
                    ans[i] = prices[i] - prices[j];
                    break;
                }
                if (j == prices.length - 1) {
                    ans[i] = prices[i];
                }
            }
        }
        return ans;
    }
}
