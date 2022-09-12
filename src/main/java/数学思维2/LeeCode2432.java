package 数学思维2;


/**
 * LCP 39. 无人机方阵
 * LeeCode 2432
 * 难度 ： 简单
 */
public class LeeCode2432 {

    public int minimumSwitchingTimes(int[][] source, int[][] target) {
        int[] temp = new int[10001];
        int[] temp1 = new int[10001];
        int ans = 0;
        for (int[] ints : source) {
            for (int anInt : ints) {
                temp[anInt]++;
            }
        }

        for (int[] ints : target) {
            for (int anInt : ints) {
                temp1[anInt]++;
            }
        }

        for (int i = 0; i < temp.length; i++) {
           ans += Math.abs(temp[i] - temp1[i]);
        }
        return ans;
    }
}
