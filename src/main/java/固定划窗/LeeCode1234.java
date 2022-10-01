package 固定划窗;


import java.io.PrintWriter;

/**
 * 1234. 替换子串得到平衡字符串
 * LeeCode 1234
 * 难度 ： 中等
 */
public class LeeCode1234 {


    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(
                new java.io.OutputStreamWriter(System.out), true);
        out.println("Hello");
    }

    public static int balancedString(String s) {
        int[] count = new int[26];
        int len = s.length();

        for (int i = 0; i < len; i++) {
            count[s.charAt(i) - 'A']++;
        }

        int left = 0, right = 0;
        int res = len;
        int average = len / 4;
        if (count['Q' - 'A'] == average && count['W' - 'A'] == average && count['E' - 'A'] == average && count['R' - 'A'] == average)
            return 0;
        while (right < len) {
            count[s.charAt(right) - 'A']--;
            while (left < len && count['Q' - 'A'] <= average && count['W' - 'A'] <= average && count['E' - 'A'] <= average && count['R' - 'A'] <= average) {
                res = Math.min(res, right - left + 1);
                //移动左指针 看能不能缩小范围
                count[s.charAt(left) - 'A']++;
                left++;
            }
            right++;
        }
        return res;
    }
}
