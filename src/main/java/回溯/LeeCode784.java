package 回溯;


import java.util.ArrayList;
import java.util.List;

/**
 * 784. 字母大小写全排列
 * LeeCode 784
 * 难度 ： 中等
 */
public class LeeCode784 {

    public static void main(String[] args) {
        letterCasePermutation("cacc");
    }

    static List<String> res = new ArrayList<>();
    static int dis = 'a' - 'A';

    public static List<String> letterCasePermutation(String s) {
        if (s.length() == 0) return res;
        char[] chars = s.toCharArray();
        //进行算法
        helper(chars, 0);
        //返回答案
        return res;
    }

    //进行回溯
    public static void helper(char[] cs, int idx) {
        //首先直接添加当前cs
        res.add(String.valueOf(cs));
        //for循环进行数值的改变,并进行单次循环后的第二次循环回溯
        for (int i = idx; i < cs.length; i++) {
            //如果为数字，那就跳过
            if (cs[i] >= '0' && cs[i] <= '9') continue;
                //如果为字母改变值，并进行回溯
            else if (cs[i] >= 'a' && cs[i] <= 'z') {
                cs[i] = (char) (cs[i] - dis);
                //值是在改变中，我们将改变中的值再改变回来，就是正确的
                helper(cs, i + 1);
                cs[i] = (char) (cs[i] + dis);
            } else {
                cs[i] = (char) (cs[i] + dis);
                helper(cs, i + 1);
                cs[i] = (char) (cs[i] - dis);
            }
        }
    }


}
