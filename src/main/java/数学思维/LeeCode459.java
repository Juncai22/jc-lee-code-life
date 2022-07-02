package 数学思维;

/**
 * 459. 重复的子字符串
 * LeeCode 459
 * 难度 ： 简单
 */
public class LeeCode459 {

    public static void main(String[] args) {
        String s = "bbababa";
        boolean b = repeatedSubstringPattern(s);
        System.out.println(b);
    }


    public static boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }
}
