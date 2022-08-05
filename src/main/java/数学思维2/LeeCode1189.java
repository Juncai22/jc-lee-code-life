package 数学思维2;

/**
 * 1189. “气球” 的最大数量
 * LeeCode 1189
 * 难度 ： 简单
 */
public class LeeCode1189 {

    public int maxNumberOfBalloons(String text) {
        int a = 0, b = 0, l = 0, o = 0, n = 0;
        for (char c : text.toCharArray()) {
            if (c == 'a') {
                a++;
            } else if (c == 'b') {
                b++;
            } else if (c == 'l') {
                l++;
            } else if (c == 'o') {
                o++;
            } else if (c == 'n') {
                n++;
            }
        }
        int res = Integer.MAX_VALUE;
        res = Math.min(res, a);
        res = Math.min(res, b);
        res = Math.min(res, l / 2);
        res = Math.min(res, o / 2);
        res = Math.min(res, n);
        return res;
    }
}
