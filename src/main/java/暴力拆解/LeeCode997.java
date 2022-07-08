package 暴力拆解;

import java.util.ArrayList;
import java.util.List;

/**
 * 997. 找到小镇的法官
 * LeeCode 997
 * 难度 ： 简单
 */
public class LeeCode997 {

    public static void main(String[] args) {
        int[][] trust = {{1,3},{1,4},{2,3},{2,4},{4,3}};
        int n = 4;
        int judge = findJudge2(n, trust);
        System.out.println(judge);
    }

    // 第一种暴力解法，根据需求减去需要的数
    public static int findJudge(int n, int[][] trust) {
        int curr = 0;
        List<Integer> list = new ArrayList<>();
        //使用list来作基本数组
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        //法官不相信任何人，这里就是排除法
        for (int[] ints : trust) {
            list.removeIf(integer -> integer == ints[0]);
        }

        if (list.size() == 1) {
            for (int[] ints : trust) {
                //查看是否任何人都相信法官
                if (list.get(0) == ints[1]) {
                    curr++;
                }
            }
            if (curr == n - 1) {
                return list.get(0);
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }
        //
        public static int findJudge2 ( int N, int[][] trust){
        //作为结果数组，将作为相信他人的人--将他相信的人++，最终结果就是法官
            int[] trusted = new int[N];
            for (int[] arr : trust) {
                trusted[arr[0] - 1]--;
                trusted[arr[1] - 1]++;
            }
            for (int i = 0; i < N; i++) {
                if (trusted[i] == N - 1) {
                    return i + 1;
                }
            }
            return -1;

    }
}
