package 数学思维2;


/**
 * 1784. 检查二进制字符串字段
 * LeeCode 1784
 * 难度 ： 简单
 */
public class LeeCode1784 {



    public boolean checkOnesSegment(String s) {
        String[] strs = s.split("0");
        return strs.length == 1;
    }
}
