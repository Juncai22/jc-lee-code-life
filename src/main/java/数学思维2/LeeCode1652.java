package 数学思维2;


import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * 1652. 拆炸弹
 * LeeCode 1652
 * 难度 ： 简单
 */
public class LeeCode1652 {

    public static void main(String[] args) {
        int[] code = {2,4,9,3};
        int k = -2;
        int[] decrypt = decrypt(code, k);
        for (int s : decrypt) {
            System.out.print(s + " ");
        }
    }
    public static int[] decrypt(int[] code, int k) {
        int[] ans = new int[code.length];
        int i = 0;
        //分多种情况，循环进行思维
        while (i < code.length){
            //k > 0;直接搞
            if (k > 0){
                int temp = 0;
                for (int m = 1; m < k + 1; m++){
                    temp += code[(i + m) % code.length];
                }
                ans[i] = temp;
                i++;
            }else if (k < 0){
                int temp = 0;
                k = -k;
                for (int j = 0; j < k; j++) {
                    //思维，绕圈圈，他的第几个数字便是 i = i + code.length - k;
                    temp += code[(i + j + code.length - k) % code.length ];
                }
                ans[i] = temp;
                i++;
                k = -k;
            }else
            //k = 0；直接换成0
            {
                ans[i] = 0;
                i++;
            }
        }
        return ans;
    }
}
