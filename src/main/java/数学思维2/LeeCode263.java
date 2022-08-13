package 数学思维2;

/**
 * 263. 丑数
 * LeeCode 263
 * 难度 ： 简单
 */
public class LeeCode263 {

    public boolean isUgly(int num) {
        if (num < 1) return false;
        while (num % 5 == 0) {
            num /= 5;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 2 == 0) {
            num >>= 1;
        }
        return num == 1;
    }
}
