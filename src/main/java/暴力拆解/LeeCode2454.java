package 暴力拆解;


import java.util.Arrays;
import java.util.Objects;

/**
 * 剑指 Offer 58 - I. 翻转单词顺序
 * LeeCode 2454
 * 难度 ： 简单
 */
public class LeeCode2454 {

    public static void main(String[] args) {
        String s = "the sky is blue";
        String s1 = reverseWords(s);
        System.out.println(s1);
    }

    public static String reverseWords(String s) {
        //将传进来的字符串以空格拆分
        String[] strings = s.trim().split(" ");
        StringBuilder stringBuffer = new StringBuilder();
        //从尾巴开始遍历
        for (int i = strings.length - 1; i >= 0; i--) {
            if (strings[i].equals("")) {
                continue;
            }
            //到头了，append然后去空格
            if (i == 0) {
                stringBuffer.append(strings[i].trim());
            } else {
                // 怕有多余的空格，去掉，再加上去
                stringBuffer.append(strings[i].trim()).append(" ");
            }
        }
        //输出String 完事，安排！
        return stringBuffer.toString();
    }
}
