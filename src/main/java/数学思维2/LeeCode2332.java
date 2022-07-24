package 数学思维2;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 2332. 坐上公交的最晚时间
 * LeeCode 2332
 * 难度 ： 中等
 */
public class LeeCode2332 {

    public static void main(String[] args) {
        int[] buses = {18, 8, 3, 12, 9, 2, 7, 13, 20, 5};
        int[] passengers = {13, 10, 8, 4, 12, 14, 18, 19, 5, 2, 30, 34};
        int capacity = 1;
        int i = latestTimeCatchTheBus(buses, passengers, capacity);
        System.out.println(i);
    }

    //方法一
    public static int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int ans = 0;

        HashSet<Integer> pset = new HashSet(); // 用于判断是否可以在乘客 i 前上车
        for (int i : passengers) {
            pset.add(i);
        }

        for (int i = 0, j = 0; i < buses.length; i++) { // i 表示车， j 表示乘客
            int in = 0;
            while (in < capacity && j < passengers.length && passengers[j] <= buses[i]) {  // 如果车 i 还有位置
                if (!pset.contains(passengers[j] - 1) && passengers[j] - 1 <= buses[i]) {  // 如果可以在某乘客前上车(passengers[j] - 1)
                    ans = Math.max(ans, passengers[j] - 1);
                }

                j++;
                in++;
            }
            if (in < capacity && !pset.contains(buses[i])) {  // 是否可以卡点上车(车来了再上车)
                ans = Math.max(ans, buses[i]);
            }

        }

        return ans;

    }

    //方法二
    public int latestTimeCatchTheBus2(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int j = 0, c = 0;
        for (int t : buses)
            for (c = capacity; c > 0 && j < passengers.length && passengers[j] <= t; ++j)
                --c;
                --j;
        int ans = c > 0 ? buses[buses.length - 1] : passengers[j]; // 在发车时到达公交站 or 上一个上车的乘客
        while (j >= 0 && passengers[j--] == ans) --ans; // 往前找没人到达的时刻
        return ans;
    }
}
