package 数学思维2;


import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 16.20. T9键盘
 * LeeCode 2472
 * 难度 ： 中等
 */
public class LeeCode2472 {


    public List<String> getValidT9Words(String num, String[] words) {
        List<String> res = new ArrayList<>();
        int length = num.length();
        int[] key = {2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6,
                7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9};
        boolean falg;
        for (String word : words) {
            falg = true;
            for (int i = 0; i < word.length(); i++) {
                if (num.charAt(i) - '0' != key[word.charAt(i) - 'A']) {
                    falg = false;
                    break;
                }
            }
            if (falg) res.add(word);
        }
        return res;
    }
}
