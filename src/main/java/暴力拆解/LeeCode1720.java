package 暴力拆解;


/**
 * 1720. 解码异或后的数组
 * LeeCode 1720
 * 难度 ： 简单
 */
public class LeeCode1720 {

    public static void main(String[] args) {

        int i = 1^1;
        System.out.println();
    }

    public int[] decode(int[] encoded, int first) {
        int[] ansInt = new int[encoded.length + 1];
        ansInt[0] = first;
        for (int i = 1; i < ansInt.length; i++) {
            ansInt[i] = ansInt[i - 1] ^ encoded[i - 1];
        }

        return ansInt;

    }
}
