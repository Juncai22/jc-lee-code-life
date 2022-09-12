package 数学思维2;


import java.util.HashMap;
import java.util.Map;

/**
 * 1124. 表现良好的最长时间段
 * LeeCode 1124
 * 难度 ： 中等
 */
public class LeeCode1124 {

    public static void main(String[] args) {
        longestWPI2(new int[]{6, 6, 9, 0, 9, 9, 9});
    }


    public static int longestWPI(int[] hours) {
        int cur = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < hours.length; i++) {
            if (hours[i] > 8) {
                cur++;
            } else {
                cur--;
            }
            if (cur > 0) {
                res = i + 1;
            } else {
                if (!map.containsKey(cur)) {
                    map.put(cur, i);
                }
                if (map.containsKey(cur - 1)) {
                    res = Math.max(res, i - map.get(cur - 1));
                }
            }
        }
        return res;
    }

    public static int longestWPI2(int[] hours) {
        int cur = 0;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < hours.length; i++) {
            if (hours[i] > 8) {
                cur++;
            } else {
                cur--;
            }
            hours[i] = cur;
        }
        for (int i = 0; i < hours.length; i++) {
            if (hours[i] > 0) {
                ans = i + 1;
            } else {
                if (!map.containsKey(hours[i])) map.put(hours[i], i);
                if (map.containsKey(hours[i] - 1)) {
                    ans = Math.max(ans, i - map.get(hours[i] - 1));
                }
            }
        }
        return ans;
    }
}
