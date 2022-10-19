package 数学思维2;


/**
 * 1790. 仅执行一次字符串交换能否使两个字符串相等
 * LeeCode 1790
 * 难度 ： 中等
 */
public class LeeCode1790 {


    public boolean areAlmostEqual(String s1, String s2) {
        int a = -1, b = a, n = s1.length();
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (a == -1) a = i;
                else if (b == -1) b = i;
                else return false;
            }
        }
        if (a == -1 || b == -1) return a == b;
        return s1.charAt(a) == s2.charAt(b) && s1.charAt(b) == s2.charAt(a);
    }
}
