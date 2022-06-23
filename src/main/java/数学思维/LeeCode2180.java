package 数学思维;

/**
 * 2180. 统计各位数字之和为偶数的整数个数
 * LeeCode 2180
 * 难度 ： 简单
 */
public class LeeCode2180 {

    public static int countEven(int num) {

        int res = 0;
        for (int i = 2; i <= num; i++) {
            if (check(i)) res++;
        }
        return res;
    }

    // 判断各个位数之和是否为偶数
    public static boolean check(int num) {
        int checkNum = 0;
        while (num > 0) {
            checkNum += (num % 10);
            num /= 10;
        }
        return checkNum % 2 == 0;

    }
}
