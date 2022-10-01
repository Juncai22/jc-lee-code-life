package 竞赛题;


/**
 * 6181. 最小偶倍数
 * LeeCode 6181
 * 难度 ： 中等
 */
public class LeeCodeJINGSAI6181 {


    public static void main(String[] args) {
        longestContinuousSubstring("yrpjofyzubfsiypfre");
    }

    public static int longestContinuousSubstring(String s) {
        //设置一个向后的指针，临时变量，最终变量
        int next = 1;
        int pink = 1;
        int ans = 1;
        //for循环寻找是否如此
        for (int i = 0; i < s.length() - 1; i++, next++) {
            if (s.charAt(i) + 1 == s.charAt(next)) {
                pink++;
            } else {
                ans = Math.max(ans, pink);
                pink = 1;
            }
        }
        //以免一次找完，还没赋值的情况
        ans = Math.max(ans, pink);
        return ans;
    }
}
