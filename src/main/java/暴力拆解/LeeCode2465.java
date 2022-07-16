package 暴力拆解;


/**
 * 剑指 Offer 58 - II. 左旋转字符串
 * LeeCode 2465
 * 难度 ： 简单
 */
public class LeeCode2465 {

    public String reverseLeftWords(String s, int n) {
        if(n == 0) return s;
        return s.substring(n)+s.substring(0, n);
    }
}
