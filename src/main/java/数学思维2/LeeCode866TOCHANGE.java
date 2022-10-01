package 数学思维2;


/**
 * 866. 回文素数
 * LeeCode 866
 * 难度 ： 中等
 */
public class LeeCode866TOCHANGE {

    public int primePalindrome(int N) {
        if (N == 1 || N == 2) {
            return 2;
        }
        //判断是否回文
        for (int i = N; i < Integer.MAX_VALUE; ) {
            if (isHuiwen(i + "") && isSushu(i)) {
                return i;
            }
            //根据nothing、xxx的 数学规律1：除 11 外的偶数位回文数，都能被 11 整除
            //跳过一些数
            if (i > 11 && (i + "").length() % 2 == 0) {
                i = (int) (Math.pow(10, (i + "").length()) + 1);
            } else {
                i++;
            }
        }
        return -1;
    }

    public boolean isHuiwen(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isSushu(int N) {
        for (int i = 2; i <= (int) Math.sqrt(N); i++) {
            if (N % i == 0) {
                return false;
            }
        }
        return true;
    }
}
