package 数学思维2;


/**
 * 1844. 将所有数字用字符替换
 * LeeCode 1844
 * 难度 ： 简单
 */
public class LeeCode1844 {

    public String replaceDigits(String s) {
        char[] ans = new char[s.length()];
        for(int i = 0; i < ans.length; i++) {
            ans[i] = i % 2 == 0 ? s.charAt(i) : (char)(s.charAt(i-1) + (s.charAt(i) - '0'));
        }
        return new String(ans);
    }
}
