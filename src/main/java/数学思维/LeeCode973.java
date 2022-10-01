package 数学思维;


import java.util.Arrays;
import java.util.Comparator;

/**
 * 973. 最接近原点的 K 个点
 * LeeCode 973
 * 难度 ： 中等
 */
public class LeeCode973 {


    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int min1 = o1[0] * o1[0] + o1[1] * o1[1];
                int min2 = o2[0] * o2[0] + o2[1] * o2[1];
                return min1 - min2;
            }
        });
        int[][] point = new int[k][2];
        for (int i = 0; i < point.length; i++) {
            point[i][0] = points[i][0];
            point[i][1] = points[i][1];
        }

        return point;
    }
}
