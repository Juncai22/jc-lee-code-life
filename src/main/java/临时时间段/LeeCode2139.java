package 临时时间段;


/**
 * 2139. 得到目标值的最少行动次数
 * LeeCode 2139
 * 难度 ： 中等
 */
public class LeeCode2139 {


    public int minMoves(int target, int maxDoubles) {
        int ans = 0;
        while (maxDoubles > 0 || target != 1) {
            while (target % 2 == 0 && maxDoubles != 0) {
                target /= 2;
                maxDoubles--;
                ans++;
            }
            if (target == 1) return ans;
            if (maxDoubles != 0) {
                target--;
                ans++;
            } else {
                return ans + target - 1;
            }
        }
        return ans;
    }
}
