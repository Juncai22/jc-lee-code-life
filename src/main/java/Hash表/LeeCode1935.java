package Hash表;


import java.util.HashSet;
import java.util.Set;

/**
 * 1935. 可以输入的最大单词数
 * LeeCode 1935
 * 难度 ： 简单
 */
public class LeeCode1935 {

    public static void main(String[] args) {
        String text = "hello world";
        String ak = "ad";
        int i = canBeTypedWords(text, ak);
        System.out.println(i);
    }

    //方法一，split。。。切割符号，暴力解法
    public static int canBeTypedWords(String text, String brokenLetters) {
        //切割弄成一个string数组
        String[] strings = text.split(" ");
        //这是得到的答案
        int ans = 0;
        //将损坏的字符串弄成字符数组
        char[] chars1 = brokenLetters.toCharArray();
        //进行遍历让字符串的每个字符检查是否有损坏的字符，如果有+1，没有继续遍历
        for (String string : strings) {
            char[] chars = string.toCharArray();
            for (char aChar : chars) {
                int change = 0;
                for (char c : chars1) {
                    if (aChar == c) {
                        ans++;
                        change = 1;
                        break;
                    }
                }
                if (change == 1) {
                    break;
                }
            }
        }

        //返回最终长度减去无法打出的字符串
        return strings.length - ans;
    }

    //Hash表
    public int canBeTypedWords2(String text, String brokenLetters) {
        int ans=0;boolean f=true;
        Set<Character> set=new HashSet<>();
        for(int i=0;i<brokenLetters.length();i++) set.add(brokenLetters.charAt(i));
        for(int i=0;i<text.length();i++){
            if(set.contains(text.charAt(i))) f=false;
            if(i==text.length()-1||text.charAt(i)==' '){
                if(f) ans++;
                else f=true;
            }
        }
        return ans;
/*
        int ans=0;
        String[] str=text.split(" ");
        Set<Character>set=new HashSet<>();
        for(int i=0;i<brokenLetters.length();i++) set.add(brokenLetters.charAt(i));
        for(String st:str){
            boolean f=true;
            for(int i=0;i<st.length()&&f;i++){
                if(set.contains(st.charAt(i))) f=false;
            }
            ans+=f?1:0;
        }
        return ans;
*/
    }
}
