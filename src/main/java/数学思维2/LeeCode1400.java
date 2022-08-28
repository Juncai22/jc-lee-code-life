package 数学思维2;


import java.util.HashSet;

/**
 * 1400. 构造 K 个回文字符串
 * LeeCode 1400
 * 难度 ： 中等
 */
public class LeeCode1400 {

    public static void main(String[] args) {
        canConstruct("\"cxayrgpcctwlfupgzirmazszgfiusitvzsnngmivctprcotcuutfxdpbrdlqukhxkrmpwqqwdxxrptaftpnilfzcmknqljgbfkzuhksxzplpoozablefndimqnffrqfwgaixsovmmilicjwhppikryerkdidupvzdmoejzczkbdpfqkgpbxcrxphhnxfazovxbvaxyxhgqxcxirjsryqxtreptusvupsstylpjniezyfokbowpbgxbtsemzsvqzkbrhkvzyogkuztgfmrprz"
                , 2);
    }

    public static boolean canConstruct(String s, int k) {
        int[] set = new int[26];
        int length = s.length();
        int ans = 0;
        if (length < k) return false;
        for (int i = 0; i < length; i++) {
            set[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < set.length; i++) {
            if (set[i] % 2 > 0){
                ans++;
            }
        }
        return k >= ans;
    }
}
