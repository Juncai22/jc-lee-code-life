package 贪心;


import java.util.Arrays;

/**
 * 646. 最长数对链
 * LeeCode 646
 * 难度 ： 中等
 */
public class LeeCode646 {

    public static void main(String[] args) {
        int[][] tem = {{-6,9},{1,6},{8,10},{-1,4},{-6,-2},{-9,8},{-5,3},{0,3}};
        LeeCode646 l = new LeeCode646();
        l.findLongestChain(tem);
    }


    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int res = 1, tmp = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > tmp) {
                res++;
                tmp = pairs[i][1];
            }
        }
        return res;
    }
}
