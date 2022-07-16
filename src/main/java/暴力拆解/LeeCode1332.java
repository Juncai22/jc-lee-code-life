package 暴力拆解;


/**
 * 1332. 删除回文子序列
 * LeeCode 133
 * 难度 ： 简单
 */
public class LeeCode1332 {

    public int removePalindromeSub(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; ++i) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                return 2;
            }
        }
        return 1;
    }
}
