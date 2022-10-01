package 数学思维;


/**
 * 796. 旋转字符串
 * LeeCode 796
 * 难度 ： 简单
 */
public class LeeCode796 {

    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }
}
