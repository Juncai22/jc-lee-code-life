package 暴力拆解;


/**
 * 剑指 Offer II 005. 单词长度的最大乘积
 * LeeCode 2494
 * 难度 ： 中等
 */
public class LeeCode2494 {

    public static void main(String[] args) {
        String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"};
        maxProduct(words);
    }

    public static int maxProduct(String[] words) {
        int ans = 0;

        //第一个for循环得到第一个数组的各位数字
        for (int i = 0; i < words.length; i++) {
            int[] coming1 = new int[26];
            int[] menu1 = changeThe(words[i], coming1);
            //第二个for循环得到另外一个数组的各位数字
            for (int j = i; j < words.length; j++) {
                int[] coming2 = new int[26];
                int[] menu2 = changeThe(words[j], coming2);
                //验证是否有相同字符
                for (int i1 = 0; i1 < menu1.length; i1++) {
                    //有则直接break
                    if (menu1[i1] > 0 && menu2[i1] > 0){
                        break;
                        //没有直接根据得到答案,并与之前的答案进行对比
                    }else if (i1 == menu1.length - 1){
                        ans = Math.max(ans,words[i].length() * words[j].length());
                    }
                }
            }
        }
        //返回ans
        return ans;
    }

    public static int[] changeThe(String word,int[] coming){
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            coming[chars[i] - 97]++;
        }
        return coming;
    }
}
