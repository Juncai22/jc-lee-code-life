package 数学思维2;


import java.util.Arrays;
import java.util.Comparator;

/**
 * 1288. 删除被覆盖区间
 * LeeCode 1288
 * 难度 ： 中等
 */
public class LeeCode1288 {

    public static void main(String[] args) {
        int[][] inte = {{66672,75156},{59890,65654},{92950,95965},{9103,31953},{54869,69855},{33272,92693},{52631,65356},{43332,89722},{4218,57729},{20993,92876}};
        removeCoveredIntervals(inte);
    }

    public static int removeCoveredIntervals(int[][] intervals) {
        //定义要被删除的结果
        int ans = 0;
        //进行依次排序，定义最高档位的地方
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) return o1[1] - o2[1];
                else return o2[0] - o1[0];
            }
        });
        //定义一个指针
        int temp = intervals.length - 1;

        //for循环依次来弄出结果
        for (int i = intervals.length - 2; i >= 0; i--) {
            if (intervals[temp][0] <= intervals[i][0]) ans++;
            else {
                temp = i;
            }
        }
        return intervals.length - ans;
    }
}
