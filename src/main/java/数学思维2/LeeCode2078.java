package 数学思维2;


import java.util.HashSet;

/**
 * 2078. 两栋颜色不同且距离最远的房子
 * LeeCode 2078
 * 难度 ： 简单
 */
public class LeeCode2078 {

    public int maxDistance(int[] colors) {
        int n = colors.length;
        int r = n - 1, l = 0;
        while(r >= 0 && colors[r] == colors[0]) --r;
        while(l < n && colors[l] == colors[n-1])++l;
        return Math.max(r, n - 1 - l);
    }
}
