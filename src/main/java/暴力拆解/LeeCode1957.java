package 暴力拆解;



/**
 * 1957. 删除字符使字符串变好
 * LeeCode 1957
 * 难度 ： 简单
 */
public class LeeCode1957 {

    public static void main(String[] args) {
        String abbcccddddeeeee = makeFancyString("abbcccddddeeeee");
        System.out.println(abbcccddddeeeee);
    }

    public static String makeFancyString(String s) {
        int m = 0;
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder(s);
        for (int i = 2; i < chars.length; i++) {
            if (chars[i] == chars[i - 1] && chars[i - 1] == chars [i - 2]){
                stringBuilder.deleteCharAt(i - 2 - m);
                m++;
            }
        }

        return new String(stringBuilder);
    }
}
