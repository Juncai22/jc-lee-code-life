package 暴力拆解;


/**
 * 1550. 存在连续三个奇数的数组
 * LeeCode 1550
 * 难度 ： 简单
 */
public class LeeCode1550 {


    public boolean threeConsecutiveOdds(int[] arr) {
        int i = 0;
        for (int i1 : arr) {
            if (i1 % 2 == 1) {
                i++;
            } else {
                i = 0;
            }
            if (i == 3) {
                return true;
            }
        }
        return false;
    }
}
