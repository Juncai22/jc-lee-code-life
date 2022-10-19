package 暴力拆解;


/**
 * 5. 最长回文子串
 * LeeCode 5
 * 难度 ： 中等
 */
public class LeeCode5 {

    public static void main(String[] args) {
        longestPalindrome("xaabacxcabaaxcabaax");
    }

    public static String longestPalindrome(String s) {
        //定义长度，最终开始位置，结束位置，临时开始位置，临时最终位置
        int n = s.length();
        int estart = 0;
        int eend = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            //临时开始位置
            start = i;
            //定义初始变量为可进入，类似于锁可进入，没有入锁
            boolean beGame = true;
            //定义第三次遍历量的指针
            int queue = n - 1;
            //开始循环，如果有相同的。则开始进入，知道没有重复的为止
            for (int j = n - 1, t = i; j > 0 && t <= j; ) {
                //进入遍历，如果未开始，并且首位字母相同，则将锁改为false，指已持有锁
                if (c == s.charAt(j) && beGame) {
                    end = j;
                    beGame = false;
                }
                //在持有锁的情况下进行判断是否相同，每一次都是在此情况下进入并设置值
                if (!beGame) {
                    if (s.charAt(t) == s.charAt(j)) {
                        t++;
                        j--;
                    } else {
                        //如果在持有锁的情况之下，不相同，则此end是不合格的，所以将之前的值重制，并且将锁开放出来
                        beGame = true;
                        t = i;
                        queue -= 1;
                        j = queue;
                    }
                }
                //如果达到界限值，并且最终长度大于之前的结果，则结果替换
                if (!beGame && (t == j || t - j == 1)) {
                    if (end + 1 - start > eend + 1 - estart) {
                        eend = end;
                        estart = start;
                    }
                }
                //为持有锁，并且不相同的时候，直接--，继续遍历
                if (c != s.charAt(j) && beGame) j--;
            }
        }
        //返回最终的结果
        return s.substring(estart, eend + 1);
    }
}
