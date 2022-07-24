package 暴力拆解;


/**
 * LCP 01. 猜数字
 * LeeCode 2345
 * 难度 ： 简单
 */
public class LeeCode2185 {

    public static void main(String[] args) {
        String[] words = {"pay", "attention", "practice", "attend"};
        String pref = "at";
        int i = prefixCount(words, pref);
        System.out.println(i);
    }

    //方法一；使用一次遍历，并使用sub来进行判断
    public static int prefixCount(String[] words, String pref) {
        int ans = 0;
        for (String word : words) {
            if (word.length() >= pref.length()) {
                String substring = word.substring(0, pref.length());
                if (substring.equals(pref)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    //方法2：直接使用api
    public int prefixCount2(String[] words, String pref) {
        // 直接遍历+API
        int cnt = 0;
        for(String s : words) {
            if(s.startsWith(pref)) {
                cnt++;
            }
        }
        return cnt;
    }
}
