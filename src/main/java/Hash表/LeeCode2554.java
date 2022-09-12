package Hash表;


import java.util.HashMap;
import java.util.HashSet;

/**
 * 剑指 Offer II 016. 不含重复字符的最长子字符串
 * LeeCode 2554
 * 难度 ： 中等
 */
public class LeeCode2554 {

    public static void main(String[] args) {
        String s = "abcabcbb";
        lengthOfLongestSubstring(s);
    }


    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int ans = 0;
        int temp = 0;
        HashMap<Character, Integer> set = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            if (set.containsKey(s.charAt(i))) {
                ans = Math.max(temp, ans);
                i = set.get(s.charAt(i)) + 1;
                set.clear();
                temp = 1;
                set.put(s.charAt(i), i);
            } else {
                set.put(s.charAt(i), i);
                temp++;
            }
        }
        ans = Math.max(temp, ans);
        return ans;
    }
}
