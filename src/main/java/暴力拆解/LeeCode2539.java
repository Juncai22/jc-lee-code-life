package 暴力拆解;


/**
 * 剑指 Offer II 072. 求平方根
 * LeeCode 2539
 * 难度 ： 简单
 */
public class LeeCode2539 {


    //方法1，直接函数
    public int mySqrt(int x) {
        return (int) Math.sqrt(x);
    }

    //方法2，二分查找
    public int mySqrt2(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
