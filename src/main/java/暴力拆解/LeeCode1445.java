package 暴力拆解;



/**
 * 1455. 检查单词是否为句中其他单词的前缀
 * LeeCode 1455
 * 难度 ： 简单
 */

public class LeeCode1445 {

    public int isPrefixOfWord(String sentence, String searchWord) {
        int ans = -2;
        String[] strings = sentence.split(" ");
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].startsWith(searchWord)){
                ans = i;
                break;
            }
        }

        return ans + 1;
    }
}
