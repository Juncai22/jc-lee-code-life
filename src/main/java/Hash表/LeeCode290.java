package Hash表;


import java.util.HashMap;
import java.util.HashSet;

/**
 * 290. 单词规律
 * LeeCode 290
 * 难度 ： 简单
 */
public class LeeCode290 {

    public static void main(String[] args) {
        wordPattern("aba",
                "dog cat cat");
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] strings = s.split(" ");
        if (strings.length != pattern.length()) return false;

        HashMap<String, Character> map = new HashMap<>();

        for (int i = 0; i < strings.length; i++) {
            if (!map.containsKey(strings[i]) && map.containsValue(pattern.charAt(i))) return false;
            if (map.containsKey(strings[i]) && !map.containsValue(pattern.charAt(i))) return false;
            if (map.containsKey(strings[i]) && map.containsValue(pattern.charAt(i))) {
                if (map.get(strings[i]) != pattern.charAt(i)) return false;
            }
            map.put(strings[i], pattern.charAt(i));
        }

        return true;
    }
}
