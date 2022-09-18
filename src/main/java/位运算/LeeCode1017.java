package 位运算;


/**
 * 1017. 负二进制转换
 * LeeCode 1017
 * 难度 ： 中等
 */
public class LeeCode1017 {

    public static void main(String[] args) {
        baseNeg2(2);
    }

    public static String baseNeg2(int n) {
        if (n == 0) {
            return "0";
        }
        StringBuilder ans = new StringBuilder("");
        while (n != 0) {
            int i = Math.abs(n) % -2;
            ans.append(i);
            n -= i;
            n /= -2;
        }
        return ans.reverse().toString();
    }
}
