package 二分查找法;


/**
 * 2064. 分配给商店的最多商品的最小值
 * LeeCode 2064
 * 难度 ： 中等
 */
public class LeeCode2064 {

    public static void main(String[] args) {
        int n = 6;
        int[] quantities = {11,6};
        minimizedMaximum(6,quantities);
    }


    //二分就是寻找最适合的一个值
    public static int minimizedMaximum(int n, int[] quantities) {
        //设置左变量,右变量
        int l = 1;
        int r = getMax(quantities);
        //进行二分搜寻
        while (l < r) {
            int temp = (l + r) / 2;
            int cur = 0;
            //如果q > temp 的倍数，那么可以在 + 1，刚刚好，则不加
            for (int q : quantities) {
                cur += (q + temp - 1) / temp;
            }
            //进行变换
            if (cur > n) {
                l = temp + 1;
            } else {
                r = temp;
            }
        }
        //返回left
        return l;
    }

    private static int getMax(int[] quantities) {
        int ans = 0;
        for (int quantity : quantities) {
            ans = Math.max(ans, quantity);
        }
        return ans;
    }
}
