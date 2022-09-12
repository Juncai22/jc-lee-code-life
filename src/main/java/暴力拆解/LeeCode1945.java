package 暴力拆解;


/**
 * 1945. 字符串转化后的各位数字之和
 * LeeCode 1945
 * 难度 ： 简单
 */
public class LeeCode1945 {

    public static void main(String[] args) {
        getLucky("iiii", 1);
    }


    public static int getLucky(String s, int k) {
        //首先将各个位数变换为数字
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            sb.append(aChar - 96);
        }
        //使用while循环，自动将各个位数相加，并且计算出结果
        int ans = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (k-- > 0) {
            int lem = 0;
            //将各个位数变换起来
            for (int i = 0; i < sb.length(); i++) {
                lem += (int) sb.charAt(i) - 48;
            }
            //使用一个中间变量，来暂时为结果，最终替换
            stringBuilder.append(lem);
            sb = stringBuilder;
            stringBuilder = new StringBuilder("");
        }
        // 将字符串转化为结果
        for (int i = 0; i < sb.length(); i++) {
            ans += (int) (sb.charAt(i) - 48) * Math.pow(10,sb.length() - i - 1);
        }
        return ans;
    }
}
