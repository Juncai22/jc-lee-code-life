package 数学思维;


import java.util.ArrayList;
import java.util.List;

/**
 * 500. 键盘行
 * LeeCode 500
 * 难度 ： 简单
 */
public class LeeCode500 {

    public static String[] findWords(String[] words) {
        List<String> list = new ArrayList<String>();
        String rowIdx = "12210111011122000010020202";
        for (String word : words) {
            boolean isValid = true;
            char idx = rowIdx.charAt(Character.toLowerCase(word.charAt(0)) - 'a');
            for (int i = 1; i < word.length(); ++i) {
                if (rowIdx.charAt(Character.toLowerCase(word.charAt(i)) - 'a') != idx) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                list.add(word);
            }
        }
        String[] ans = new String[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
