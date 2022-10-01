package 数学思维2;


import java.util.Arrays;

/**
 * 2358. 分组的最大数量
 * LeeCode 2358
 * 难度 ： 中等
 */
public class Leecode2358 {


    public int maximumGroups(int[] grades) {
        Arrays.sort(grades);
        if (grades.length < 3) return 0;
        int ans = 0;
        int temp = grades.length;
        while (temp > ans) {
            ans++;
            temp -= ans;
        }
        return ans;
    }
}
