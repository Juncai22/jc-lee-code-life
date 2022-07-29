package 数学思维2;


/**
 * 409. 最长回文串
 * LeeCode 409
 * 难度 ： 简单
 */
public class LeeCode409 {

    public static void main(String[] args) {
        longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth");
    }

    public static int longestPalindrome(String s) {
        //这是双数答案
        int ans = 0;
        //这是单数临时答案
        int temp = 0;
        //按照ASCII码进行数据排版
        char[] chars = s.toCharArray();
        int[] ansTemp = new int[123];
        for (char aChar : chars) {
            ansTemp[aChar]++;
        }
        //根据此相加
        for (int an : ansTemp) {
            if (an % 2 == 0) {
                ans += an;
            } else if (an % 2 == 1) {
                temp += an - 1;
            }
        }
        return ans + temp + 1 > s.length() ? ans + temp : ans + temp + 1 ;
    }
}
