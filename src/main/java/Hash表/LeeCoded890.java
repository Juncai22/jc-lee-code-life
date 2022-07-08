package Hash表;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 890. 查找和替换模式
 * LeeCode 890
 * 难度 ： 中等
 */
public class LeeCoded890 {

    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        //当做返回当量
        List<String> ans = new ArrayList<>();
        //循环遍历words来查看是否满足要求
        for (String word : words) {
            if (match(word,pattern) && match(pattern,word)){
                ans.add(word);
            }
        }
        //返回最重结果
        return ans;
    }

    public static boolean match(String word,String ans){
        //利用Hash表表示一一对应
        HashMap<Character,Character> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char x = word.charAt(i);
            char y = ans.charAt(i);
            //如果没有那么加入
            if (!map.containsKey(x)){
                map.put(x,y);
            }else if (map.get(x) != y){
                //如果有key，那么没有对应，就直接反会错误
                return false;
            }
        }
        //如果循环遍历完之后还是TRUE，直接返回TRUE
        return true;
    }
}
