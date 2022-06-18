package 二分查找法;

/**
 * 441. 排列硬币
 * LeeCode 441
 * 难度 ： 简单
 */
public class LeeCode461 {

    public int arrangeCoins(int n) {
        //从左边开始，设置下标
        int left = 1, right = n;
        while (left < right) {
            //利用二分查找进行查找
            int mid = (right - left + 1) / 2 + left;
            if ((long) mid * (mid + 1) <= (long) 2 * n) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        //返回结果
        return left;
    }
}
