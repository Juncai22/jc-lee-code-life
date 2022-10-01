package 暴力拆解;


import java.util.HashMap;

/**
 * 2244. 完成所有任务需要的最少轮数
 * LeeCode 2244
 * 难度 ： 中等
 */
public class LeeCode2244 {


    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;

        //在各个value中3种方案皆可得到答案
        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        for (Integer value : map.values()) {
            if (value == 1) return -1;
            if (value % 3 == 0) ans += value / 3;
            else ans += value / 3 + 1;
        }
        return ans;
    }
}
