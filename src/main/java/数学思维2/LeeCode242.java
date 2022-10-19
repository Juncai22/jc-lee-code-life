package 数学思维2;


/**
 * 242. 有效的字母异位词
 * LeeCode 242
 * 难度 ： 简单
 */
public class LeeCode242 {


    public boolean isAnagram(String s, String t) {
        //定义一个26数组
        int[] record = new int[26];
        //进行加减乘除
        for (char c : s.toCharArray()) {
            record[c - 'a'] += 1;
        }
        for (char c : t.toCharArray()) {
            record[c - 'a'] -= 1;
        }
        //看一下是否符号都相等
        for (int i : record) {
            if (i != 0) {
                return false;
            }
        }
        //返回true
        return true;
    }
}
