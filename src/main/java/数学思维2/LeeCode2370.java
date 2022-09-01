package 数学思维2;


/**
 * 2370. 最长理想子序列
 * LeeCode 2370
 * 难度 ： 中等
 */
public class
LeeCode2370 {

    public static void main(String[] args) {
        longestIdealString("acfgbd", 2);
    }

    public static int longestIdealString(String s, int k) {
        int[] dp = new int[26];
        int resultMax = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            int max = 0;
            //进行范围运算，在一个范围之内，进行最大级的搜寻
            for (int j = index - k < 0 ? 0 : index - k; j <= (index + k > 25 ? 25 : index + k); j++) {
                max = Math.max(dp[j], max);
            }
            //在这个最大级中在+1
            dp[index] = max + 1;
            //这就是搜寻最大级
            resultMax = Math.max(resultMax, dp[index]);
        }
        return resultMax;
    }
}
