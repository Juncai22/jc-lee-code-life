package Hash表;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2001. 可互换矩形的组数
 * LeeCode 2001
 * 难度 ： 中等
 */
public class LeeCode2001 {

    public static void main(String[] args) {
//        int[][] temp = {{4, 8}, {3, 6}, {10, 20}, {15, 30}};
        int[][] temp = {{4, 5}, {7, 8}};

        interchangeableRectangles(temp);
    }

    public static long interchangeableRectangles(int[][] rectangles) {
        Map<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < rectangles.length; i++) {
            map.put(1.0 * rectangles[i][1] / rectangles[i][0], map.getOrDefault(1.0 * rectangles[i][1] / rectangles[i][0], 0) + 1);
        }
        long ans = 0;
        for (double key : map.keySet()) {
            ans += (long) map.get(key) * (long) (map.get(key) - 1) / 2;
        }
        return ans;
    }
}
