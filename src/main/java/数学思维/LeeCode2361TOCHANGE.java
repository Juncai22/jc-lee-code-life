package 数学思维;

/**
 * LCP 33. 蓄水
 * LeeCode 2361
 * 难度 ： 中等
 */
public class LeeCode2361TOCHANGE {

    public int storeWater(int[] bucket, int[] vat) {
        int n = vat.length;
        int max = -1;
        for (int i = 0; i < n;i++) {
            if (vat[i] > max) {
                max  = vat[i];
            }
        }
        if (max == 0) {
            return 0;
        }

        int min = 100000;
        for (int i = 1; i <= max;i++) {
            int cur = i;

            for (int j = 0; j < n; j++) {
                int least = vat[j] / i + (vat[j] % i == 0 ? 0 : 1);
                cur += Math.max(0, least - bucket[j]);
            }
            if (cur < min) {
                min = cur;
            }
        }
        return min;
    }
}
