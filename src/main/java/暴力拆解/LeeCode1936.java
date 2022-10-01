package 暴力拆解;


import java.util.List;

/**
 * 1936. 新增的最少台阶数
 * LeeCode 1936
 * 难度 ： 中等
 */
public class LeeCode1936 {

    public static void main(String[] args) {
        int[] rungs = {3,6,8,10};
        addRungs(rungs,3);
    }

    public static int addRungs(int[] rungs, int dist) {
        //暴力解法
        int ans = (rungs[0] - 1) / dist;
        //直接判断差距之间的大小
        for (int i = 0; i < rungs.length - 1; i++) {
            if (rungs[i] + dist < rungs[i + 1]){
                ans += (rungs[i + 1] - rungs[i] - 1) / dist;
            }
        }
        return ans;
    }
}
