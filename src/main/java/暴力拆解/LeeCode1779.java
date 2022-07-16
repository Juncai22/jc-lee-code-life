package 暴力拆解;


/**
 * 1779. 找到最近的有相同 X 或 Y 坐标的点
 * LeeCode 1779
 * 难度 ： 简单
 */
public class LeeCode1779 {

    public int nearestValidPoint(int x, int y, int[][] points) {
        int ans = -1;
        int min = 999999;
        //简单进行取舍
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                int bes = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y);
                if (bes < min) {
                    min = bes;
                    ans = i;
                }
            }
        }


        return ans;
    }
}
