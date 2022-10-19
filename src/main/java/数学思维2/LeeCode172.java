package 数学思维2;


/**
 * 172. 阶乘后的零
 * LeeCode 172
 * 难度 ： 中等
 */
public class LeeCode172 {


    public int trailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }
}
