package 双指针;


/**
 * 剑指 Offer II 019. 最多删除一个字符得到回文
 * LeeCode 2582
 * 难度 ： 简单
 */
public class LeeCode2582 {


    public static void main(String[] args) {
        validPalindrome("acxcybycxcxa");
    }

    public static boolean validPalindrome(String s) {
        int n = s.length();
        int l = 0;
        int r = n - 1;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return valid(s, l + 1, r) || valid(s, l, r - 1);
            }
        }
        return true;
    }

    public static boolean valid(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
