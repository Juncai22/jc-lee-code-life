package 数学思维2;


import java.util.ArrayList;
import java.util.List;

/**
 * 821. 字符的最短距离
 * LeeCode 821
 * 难度 ： 简单
 */
public class LeeCode821 {

    public int[] shortestToChar(String s, char c) {
        char ch[] = s.toCharArray();
        int ans[] = new int[ch.length];
        int idx = -10005;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == c) {
                idx = i;
            }
            ans[i] = i - idx;
        }
        idx = 20010;
        for (int i = ch.length - 1; i >= 0; i--) {
            if (ch[i] == c) {
                idx = i;
            }
            ans[i] = Math.min(ans[i], idx - i);
        }
        return ans;
    }
}
