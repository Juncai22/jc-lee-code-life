package 数学思维;


/**
 * 面试题 16.05. 阶乘尾数
 * LeeCode 2651
 * 难度 ： 简单
 */
public class LeeCode2651 {
    public static void main(String[] args) {
        int i = trailingZeroes(13);
        System.out.println(i);
    }

    public static int trailingZeroes(int n) {
        int ans = 0;
        while (n != 0) {
            n /= 5;
            ans += n;
        }
        return ans;
    }
}
