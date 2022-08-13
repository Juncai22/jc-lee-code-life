package Hash表;


import java.util.HashSet;

/**
 * 387. 字符串中的第一个唯一字符
 * LeeCode 387
 * 难度 ： 简单
 */
public class LeeCode387 {

    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        //第一个Hash筛选一次的
        HashSet<Character> hashSet = new HashSet<>();
        //第二个筛选只有两次的
        HashSet<Character> temp = new HashSet<>();
        //进行for循环进行第一次筛选
        for (int i = 0; i < chars.length; i++) {
            if (hashSet.contains(chars[i])) {
                temp.add(chars[i]);
            } else {
                hashSet.add(chars[i]);
            }
        }
        //第二次筛选如果两次hash里面没有值，则返回i;
        for (int i = 0; i < chars.length; i++) {
            if (!temp.contains(chars[i])) {
                return i;
            }
        }
        return -1;
    }
}
