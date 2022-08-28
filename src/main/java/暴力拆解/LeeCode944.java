package 暴力拆解;


/**
 * 944. 删列造序
 * LeeCode 944
 * 难度 ： 简单
 */
public class LeeCode944 {


    public int minDeletionSize(String[] strs) {
        int ans = 0;
        int n = strs.length;
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < n; j++) {
                if (strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}
