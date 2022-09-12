package 数学思维2;


import java.util.List;

/**
 * 806. 写字符串需要的行数
 * LeeCode 806
 * 难度 ： 简单
 */
public class LeeCode806 {


    public int[] numberOfLines(int[] widths, String s) {
        int[] ans = new int[2];
        int lie = 0;
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            temp += widths[s.charAt(i) - 'a'];
            if (temp > 100) {
                lie++;
                temp = widths[s.charAt(i) - 'a'];
            }
        }
        ans[0] = lie;
        ans[1] = temp;
        return ans;
    }
}
