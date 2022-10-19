package 位运算;


import java.util.Arrays;

/**
 * 1073. 负二进制数相加
 * LeeCode 1073
 * 难度 ： 中等
 */
public class LeeCode1073TOCHANGE {

    public static void main(String[] args) {
        double pow = Math.pow(-2, 1000);
        System.out.println(pow);
    }


    public int[] addNegabinary(int[] arr1, int[] arr2) {

        if (arr2.length > arr1.length) {
            int[] temp = arr1;
            arr1 = arr2;
            arr2 = temp;
        }
        int len1 = arr1.length;
        int len2 = arr2.length;
        int len3 = len1 + 2;
        int[] res = new int[len3];
        int carry = 0;
        for (int i = 1; i <= len1; i++) {
            int sum = arr1[len1 - i] + carry;
            if (i <= len2) {
                sum += arr2[len2 - i];
            }
            if (sum >= 0) {
                res[len3 - i] = sum % 2;
                carry = -(sum / 2);
            } else {
                res[len3 - i] = 2 + sum;
                carry = 1;
            }
        }
        if (carry != 0) {
            res[0] = res[1] = 1;
        }
        int index = 0;
        while (index < len3 - 1 && res[index] == 0) {
            index++;
        }
        return Arrays.copyOfRange(res, index, len3);
    }
}
