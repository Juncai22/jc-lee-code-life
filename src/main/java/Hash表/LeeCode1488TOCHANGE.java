package Hash表;

import java.util.*;

public class LeeCode1488TOCHANGE {

    public static void main(String[] args) {
        avoidFlood(new int[]{1, 0, 2, 3, 0, 1, 2});
    }

    public static int[] avoidFlood(int[] rains) {
        int[] ans = new int[rains.length];
        Map<Integer, Integer> waterMap = new HashMap<>();
        BitSet empty = new BitSet();
        for (int i = 0; i < rains.length; ++i) {
            if (rains[i] > 0) {
                if (waterMap.get(rains[i]) != null) {
                    int next = empty.nextSetBit(waterMap.get(rains[i]) + 1);
                    if (next != -1) {
                        empty.set(next, false);
                        ans[next] = rains[i];
                    } else {
                        return new int[0];
                    }
                }
                waterMap.put(rains[i], i);
                ans[i] = -1;
            } else {
                ans[i] = 1;
                empty.set(i);
            }
        }
        return ans;
    }
}
