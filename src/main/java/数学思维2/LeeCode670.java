package 数学思维2;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 670. 最大交换
 * LeeCode 670
 * 难度 ： 中等
 */
public class LeeCode670 {

    public static void main(String[] args) {
        maximumSwap(2736);
    }

    public static int maximumSwap(int num) {
        String nums = num + "";
        char[] chars = nums.toCharArray();
        char[] clone = chars.clone();
        char temp = '0';
        char tem = '0';
        //先进行第一次排序，来看得到的最大值
        Arrays.sort(clone);

        //进行for循环，看与最大值差距几何，并进行一位转换，然后已将其保存为临时变量
        for (int i = 0; i < nums.length(); i++) {
            if (nums.charAt(i) != clone[nums.length() - i - 1]) {
                temp = chars[i];
                tem = clone[nums.length() - i - 1];
                chars[i] = clone[nums.length() - i - 1];
                break;
            }
        }

        //转换第二位数值
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == tem) {
                chars[i] = temp;
                break;
            }
        }
        //返回结果
        return Integer.parseInt(new String(chars));
    }
}
