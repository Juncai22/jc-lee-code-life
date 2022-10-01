package 竞赛题;


import java.util.Stack;

/**
 * 001. 气温变化趋势
 * LeeCode 001
 * 难度 ： 简单
 */
public class LeeCodeJINGSAI001 {

    public static void main(String[] args) {
        int[] tea = {21, 18, 18, 18, 31};
        int[] teb = {34, 32, 16, 16, 17};
        temperatureTrend(tea, teb);
    }

    public static int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int[] aen = new int[temperatureA.length - 1];
        int[] ben = new int[temperatureA.length - 1];
        int t = 0;
        int ans = 0;
        int temp = 0;

        for (int i = 0; i < temperatureA.length - 1; i++) {
            if (temperatureA[i + 1] != temperatureA[i])
                aen[t] = temperatureA[i + 1] - temperatureA[i] > 0 ? 1 : -1;
            else aen[t] = 0;
            t++;
        }
        t = 0;
        for (int i = 0; i < temperatureA.length - 1; i++) {
            if (temperatureB[i + 1] != temperatureB[i])
                ben[t] = temperatureB[i + 1] - temperatureB[i] > 0 ? 1 : -1;
            else ben[t] = 0;
            t++;
        }

        for (int i = 0; i < aen.length; i++) {
            if (aen[i] == ben[i]) temp++;
            else temp = 0;
            ans = Math.max(temp, ans);
        }
        return ans;
    }
}
