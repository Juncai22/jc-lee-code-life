package 暴力拆解;

/**
 * 面试题 10.05. 稀疏数组搜索
 * LeeCode 2637
 * 难度 ： 简单
 */
public class LeeCode2637 {

    public int findString(String[] words, String s) {
        for (int i = 0; i < words.length; i++) {
            if (s.equals(words[i])){
                return i;
            }
        }
        return -1;
    }
}
