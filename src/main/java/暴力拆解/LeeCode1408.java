package 暴力拆解;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1408. 数组中的字符串匹配
 * LeeCode 1408
 * 难度 ： 简单
 */
public class LeeCode1408 {

    public List<String> stringMatching(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].contains(words[i])) {
                    ans.add(words[i]);
                    break;
                }
            }
        }
        return ans;
    }
}
