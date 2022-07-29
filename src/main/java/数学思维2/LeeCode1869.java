package 数学思维2;


/**
 * 1869. 哪种连续子字符串更长
 * LeeCode 1869
 * 难度 ： 简单
 */

public class LeeCode1869 {

    public static void main(String[] args) {
        String s = "111000";
        boolean b = checkZeroOnes(s);
        System.out.println(b);
    }

    public static boolean checkZeroOnes(String s) {
        //含1的最终结果
        int oneMode = 0;
        //含1的临时结果
        int onetemp = 0;
        //含0的最终结果
        int zeroMode = 0;
        //含0的临时结果
        int zerotemp = 0;
        char[] chars = s.toCharArray();
        //排除长度为1的情况
        if (s.length() == 1){
            return chars[0] == '1';
        }
        //从1开始
        for (int i = 1; i < chars.length; i++) {
            //如果i - 1位为1则临时结果++，而且当i位为0时，可能0只有一位的情况，所以加了在换为原来的数
            if (chars[i - 1] == '1'){
                onetemp++;
                if (chars[i] == '0'){
                    zerotemp++;
                    zeroMode = Math.max(zeroMode,zerotemp);
                    zerotemp = 0;
                    oneMode = Math.max(oneMode,onetemp);
                    onetemp = 0;
                }else if (chars[i] == '1' && i == chars.length - 1){
                    onetemp++;
                    oneMode = Math.max(oneMode,onetemp);
                }
                continue;
            }
            //如果i - 1位为0则临时结果++，而且当i位为1时，可能1只有一位的情况，所以加了在换为原来的数
            if (chars[i - 1] == '0'){
                zerotemp++;
                if (chars[i] == '1'){
                    onetemp++;
                    oneMode = Math.max(oneMode,onetemp);
                    onetemp = 0;
                    zeroMode = Math.max(zeroMode,zerotemp);
                    zerotemp = 0;
                }else if (chars[i] == '0' && i == chars.length - 1){
                    zerotemp++;
                    zeroMode = Math.max(zeroMode,zerotemp);
                }
            }
        }
        //返回结果
        return oneMode > zeroMode;
    }
}
