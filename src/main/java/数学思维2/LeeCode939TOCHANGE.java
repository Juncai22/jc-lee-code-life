package 数学思维2;


import java.util.*;

/**
 * 939. 最小面积矩形
 * LeeCode 939
 * 难度 ： 简单
 */
public class LeeCode939TOCHANGE {

    public static void main(String[] args) {
        int[][] points = {{1, 1}, {1, 3}, {3, 1}, {3, 3}, {4, 1}, {4, 3}};
        minAreaRect(points);
    }

    public static int minAreaRect(int[][] points) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] point : points) {
            if (!map.containsKey(point[0])) map.put(point[0], new HashSet<>());
            map.get(point[0]).add(point[1]);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int x1 = points[i][0], y1 = points[i][1], x2 = points[j][0], y2 = points[j][1];
                //一定要加上这句，不然大概率tle
                if (x1 == x2 || y1 == y2) continue;
                if (map.get(x1).contains(y2) && map.get(x2).contains(y1)) {
                    int abs = Math.abs((x1 - x2) * (y1 - y2));
                    res = Math.min(res, abs == 0 ? Integer.MAX_VALUE : abs);
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
