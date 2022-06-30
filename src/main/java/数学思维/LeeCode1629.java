package 数学思维;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 1629. 按键持续时间最长的键
 * LeeCode 1629
 * 难度 ： 简单
 */
public class LeeCode1629 {


    public char slowestKey(int[] releaseTimes, String keysPressed) {
        //将字符串改为Char字符集
        char[] chars = keysPressed.toCharArray();
        int m = releaseTimes[0];
        //作指针
        int k = 0;
        //for循环遍历，得到数据
        for (int i = 1; i < releaseTimes.length; i++) {
            if (m > releaseTimes[i] - releaseTimes[i - 1]) {
            } else if (m == releaseTimes[i] - releaseTimes[i - 1]) {
                k = chars[k] > chars[i] ? k : i;
            } else {
                m = releaseTimes[i] - releaseTimes[i - 1];
                k = i;
            }
        }
        //返回得到的指针数据
        return keysPressed.charAt(k);
    }
}