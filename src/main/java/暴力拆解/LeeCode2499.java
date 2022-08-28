package 暴力拆解;


import java.util.HashSet;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 * LeeCode 2499
 * 难度 ： 简单
 */
public class LeeCode2499 {

    public static void main(String[] args) {
        firstUniqChar("leetcode");
    }

    public static char firstUniqChar(String s) {
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (set1.contains(s.charAt(i))) set2.add(s.charAt(i));
            else set1.add(s.charAt(i));
        }
        char ans = ' ';
        int i = 0;
        while (i < s.length()) {
            if (!set2.contains(s.charAt(i))) {
                return s.charAt(i);
            }
            i++;

        }
        return ans;
    }
}
