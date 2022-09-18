package Hash表;


import java.util.HashMap;
import java.util.HashSet;

/**
 * 1624. 两个相同字符之间的最长子字符串
 * LeeCode 1624
 * 难度 ： 简单
 */
public class LeeCode1624 {


    public int maxLengthBetweenEqualCharacters(String s) {
        //使用hash记录是否重复
        HashMap<Character, Integer> hashSet = new HashMap<>();
        char[] chars = s.toCharArray();
        int ans = -1;
        //进行简单遍历，最左边的字符，与最右边的相同字符相减，就会得到最大差距
        for (int i = 0; i < chars.length; i++) {
            if (hashSet.containsKey(chars[i])) {
                ans = Math.max(ans, i - hashSet.get(chars[i]) - 1);
            } else {
                hashSet.put(chars[i], i);
            }
        }
        //返回结果
        return ans;
    }
}
