package 数学思维;


/**
 * 剑指 Offer II 032. 有效的变位词
 * LeeCode 2509
 * 难度 ： 简单
 */
public class LeeCode2509 {
    public static void main(String[] args) {
        int s = 'a';
        System.out.println(s);
    }

    public boolean isAnagram(String s, String t) {
        //先进行最基本的判断，如果最基本的判断都不满足，直接返回false
        if ((s.length() != t.length()) || (s.length() == 1 && t.length() == 1)){
            return false;
        }
        //进行数组的虚拟设计
        int[] stempZu = new int[26];
        int[] ttempZu = new int[26];
        //将字符串弄成字符集
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        //进行字符分析
        for (char sChar : sChars) {
            stempZu[sChar - 97]++;
        }
        for (char tChar : tChars) {
            ttempZu[tChar - 97]++;
        }
        //查看是否正确
        for (int i = 0; i < stempZu.length; i++) {
            if (stempZu[i] == ttempZu[i] && i == stempZu.length - 1){
                return true;
            }
            if (stempZu[i] == ttempZu[i]){
            }else{
                return false;
            }
        }
        return false;
    }
}
