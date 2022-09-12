package Hash表;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 205. 同构字符串
 * LeeCode 205
 * 难度 ： 简单
 */
public class LeeCode205 {

    public static void main(String[] args) {
    }


    public boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> map0 = new HashMap<>();
        Map<Character, Integer> map1 = new HashMap<>();

        if (s.length() != t.length()) return false;
        for (int i = 0; i < s.length(); i++) {
            if (map0.containsKey(s.charAt(i)) && !map1.containsKey(t.charAt(i))) return false;
            if (!map0.containsKey(s.charAt(i)) && map1.containsKey(t.charAt(i))) return false;
            if (!map0.containsKey(s.charAt(i)) && !map1.containsKey(t.charAt(i))) {
                map0.put(s.charAt(i), i);
                map1.put(t.charAt(i), i);
            }
            if (map0.containsKey(s.charAt(i)) && map1.containsKey(t.charAt(i)))
                if (!Objects.equals(map0.get(s.charAt(i)), map1.get(t.charAt(i)))) return false;
        }


        return true;
    }
}
