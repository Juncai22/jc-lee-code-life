package 二分查找法;

import java.util.Arrays;

/**
 * 制作 m 束花所需的最少天数
 * LeeCode 1482
 * 难度 ： 中等
 */
class LeeCode1482 {
    public int minDays(int[] bloomDay, int m, int k) {

        if (m > bloomDay.length / k) return -1; // 此时无论如何都制作不出来m束花

        // 只要 m <= bloomDay.length / k, 成立，无论如何都能制作出来
        // 调用两次stream()方法求最值的效率较低，可以使用常规方法替代！
        int low = Arrays.stream(bloomDay).min().getAsInt(); // 花开的最小天数
        int high = Arrays.stream(bloomDay).max().getAsInt(); // 花开的最大天数

        // 如果可以制作m束花，天数一定在low和high之间，因此使用二分查找
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (make(bloomDay, m, k, mid)) {
                high = mid;
            } else low = mid + 1;
        }
        return low;

    }

    public boolean make(int[] bloomDay, int m, int k, int days) {
        int flowers = 0; // 代表可用的花的个数
        int makeFlowers = 0; // 代表当前天数days可以制作出的花的数量
        int n = bloomDay.length;
        for (int j : bloomDay) {
            if (j <= days) {
                flowers++; // 只要开花所需天数小于等于days, 则说明当前花可用
                if (flowers == k) {   // 当前花的数量满足可以制作一束花的数量k时，则制作出的花的数量makeFlowers++;并重置makeFlowers
                    makeFlowers++;
                    flowers = 0;  // 重置当前可用花的数量
                }
            } else flowers = 0; // 因为需要连续的k朵花，因此只要中间有一朵花没开, flowers就重置为0

        }
        return makeFlowers >= m; // 只要 makeFlowers >= m 就说明可以满足要求
    }
}