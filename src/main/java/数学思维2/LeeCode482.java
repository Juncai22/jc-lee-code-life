package 数学思维2;


/**
 * 482. 密钥格式化
 * LeeCode 482
 * 难度 ： 简单
 */
public class LeeCode482 {
    public static void main(String[] args) {
        String s = "abc-asd-ade";
        String sou = s.substring('-');
        System.out.println(sou);
    }

    public String licenseKeyFormatting(String s, int k) {
        StringBuilder ans = new StringBuilder();
        int cnt = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '-') {
                cnt++;
                ans.append(Character.toUpperCase(s.charAt(i)));
                if (cnt % k == 0) {
                    ans.append("-");
                }
            }
        }
        if (ans.length() > 0 && ans.charAt(ans.length() - 1) == '-') {
            ans.deleteCharAt(ans.length() - 1);
        }

        return ans.reverse().toString();
    }
}
