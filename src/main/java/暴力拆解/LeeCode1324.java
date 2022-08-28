package 暴力拆解;


import java.util.ArrayList;
import java.util.List;

/**
 * 1324. 竖直打印单词
 * LeeCode 1324
 * 难度 ： 简单
 */
public class LeeCode1324 {

    public static void main(String[] args) {
        printVertically("TO BE OR NOT TO BE");
    }


    public static List<String> printVertically(String s) {
        //首先进分割，将字符串分割以 为界限的数组
        String[] strings = s.split(" ");
        int max = 0;
        //先得到最大的长度
        for (String string : strings) {
            max = Math.max(string.length(), max);
        }
        //然后利用stringBuilder的特性进行改变
        StringBuilder[] stringBuilders = new StringBuilder[max];
        List<String> stringList = new ArrayList<>();
        //for循环将一个个字母放入
        for (int i = 0; i < max; i++) {
            stringBuilders[i] = new StringBuilder("");
            for (int j = 0; j < strings.length; j++) {
                if (strings[j].length() > i) {
                    stringBuilders[i].append(strings[j].charAt(i));
                } else {
                    stringBuilders[i].append(' ');
                }
            }
        }
        //查看是否最后为 ，如果是则删除，不是则改为string并进行装箱
        for (StringBuilder stringBuilder : stringBuilders) {
            while (stringBuilder.charAt(stringBuilder.length() - 1) == ' ') {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            String ansa = new String(stringBuilder);
            stringList.add(ansa);
        }
        //返回结果
        return stringList;
    }


}
