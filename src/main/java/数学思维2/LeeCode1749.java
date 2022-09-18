package 数学思维2;


/**
 * 1749. 任意子数组和的绝对值的最大值
 * LeeCode 1749
 * 难度 ： 中登
 */
public class LeeCode1749 {

    public static void main(String[] args) {
        maxAbsoluteSum(new int[]{2,-5,1,-4,3,-2});
    }

    public static int maxAbsoluteSum(int[] nums) {
        int prefix = 0, max = 0, min = 0;

        for (int x : nums) {
            prefix += x;
            if (prefix > max){
                max = prefix;
            }
            if (prefix < min) {
                min = prefix;
            }
        }

        return max - min;

    }
}
