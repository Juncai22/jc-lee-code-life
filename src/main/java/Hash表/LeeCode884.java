package Hash表;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 884. 两句话中的不常见单词
 * LeeCode 884
 * 难度 ： 简单
 */
public class LeeCode884 {

    public String[] uncommonFromSentences(String s1, String s2) {
        //现将s1，s2进行分词
        String[] s1Tos = s1.split(" ");
        String[] s2Tos = s2.split(" ");
        //使用两个Hash，致使数的随机
        HashSet<String> stringHashSet = new HashSet<>();
        HashSet<String> stringHashSet2 = new HashSet<>();
        //进行两次遍历，将重复的一一删除
        for (String s1To : s1Tos) {
            if (stringHashSet2.contains(s1To)) {
                stringHashSet.remove(s1To);
            } else {
                stringHashSet2.add(s1To);
                stringHashSet.add(s1To);
            }
        }
        for (String s1To : s2Tos) {
            if (stringHashSet2.contains(s1To)) {
                stringHashSet.remove(s1To);
            } else {
                stringHashSet2.add(s1To);
                stringHashSet.add(s1To);
            }
        }
        //返回toArray
        return stringHashSet.toArray(new String[0]);
    }
}
