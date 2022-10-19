package 暴力拆解;


/**
 * 1828. 统计一个圆中点的数目
 * LeeCode 1828
 * 难度 ： 中等
 */
public class LeeCode1828 {


    public int[] countPoints(int[][] points, int[][] queries) {
        int n = queries.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            int r = queries[i][2];
            int cnt = 0;
            for (int[] point : points) {
                int x = point[0];
                int y = point[1];
                if (isValid(x, y, a, b, r)) {
                    cnt++;
                }
            }
            res[i] = cnt;
        }
        return res;
    }

    private boolean isValid(int x, int y, int a, int b, int r) {
        int dis = (x - a) * (x - a) + (y - b) * (y - b);
        return dis <= r * r;
    }
}
