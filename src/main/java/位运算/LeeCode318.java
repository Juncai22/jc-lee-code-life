package 位运算;


import java.util.*;

/**
 * 318. 最大单词长度乘积
 * LeeCode 318
 * 难度 ： 简单
 */
public class LeeCode318 {

    public static void main(String[] args) {
        boolean x = (4194311 & 16416) == 0;
    }

    public static int maxProduct(String[] words) {
        //words的长度
        int length = words.length;
        //定义一个与其同样长度的int数组
        int[] masks = new int[length];
        for (int i = 0; i < length; i++) {
            String word = words[i];
            int wordLength = word.length();
            for (int j = 0; j < wordLength; j++) {
                //进行位运算，以二进制来开始计算，将每位数字都填充进二进制
                masks[i] |= 1 << (word.charAt(j) - 'a');
            }
        }
        int maxProd = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                //验证是否有相同的位数，如果没有则就位0，有就是其他数字
                if ((masks[i] & masks[j]) == 0) {
                    //得到最大数值
                    maxProd = Math.max(maxProd, words[i].length() * words[j].length());
                }
            }
        }
        return maxProd;
    }
}
