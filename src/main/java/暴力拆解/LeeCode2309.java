package 暴力拆解;


/**
 * 2309. 兼具大小写的最好英文字母
 * LeeCode 2309
 * 难度 ： 简单
 */
public class LeeCode2309 {

    public String greatestLetter(String s) {
        String result = "";
        for (int i = 25; i >= 0; i--) {
            String upper = String.valueOf((char) (i + 65));
            String lower = String.valueOf((char) (i + 97));
            if (s.indexOf(upper) != -1 && s.indexOf(lower) != -1) {
                return upper;
            }
        }
        return result;
    }
}
