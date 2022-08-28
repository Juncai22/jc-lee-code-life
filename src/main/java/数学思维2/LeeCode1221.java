package 数学思维2;


import java.util.HashSet;

/**
 * 1221. 分割平衡字符串
 * LeeCode 1221
 * 难度 ： 简单
 */
public class LeeCode1221 {

    public int balancedStringSplit(String s) {
        int num = 0;
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R')
                n++;
            if (s.charAt(i) == 'L')
                n--;
            if (n == 0)
                num++;
        }
        return num;
    }
}
