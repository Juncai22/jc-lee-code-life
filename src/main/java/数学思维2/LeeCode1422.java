package 数学思维2;


import java.util.ArrayList;
import java.util.List;

/**
 * 1422. 分割字符串的最大得分
 * LeeCode 1422
 * 难度 ： 简单
 */
public class LeeCode1422 {

    public static void main(String[] args) {
        String s = "1111";
        int i = maxScore(s);
        System.out.println(i);
    }

    public static int maxScore(String s) {
        char[] charArray = s.toCharArray();
        int temp = 0;
        int max = 0;
        int ans = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '0') {
                temp++;
            } else {
                temp--;
            }
            if (max == temp) {
                list.add(i);
            } else if (max < temp) {
                list.clear();
                list.add(i);
            }
            max = Math.max(temp, max);
        }
        if (list.size() == 0) {
            list.add(0);
        }
        Integer integer = list.get(0);
        if (integer == charArray.length - 1){
            integer--;
        }
        for (int i = 0; i < charArray.length; i++) {
            if (i <= integer) {
                if (charArray[i] == '0') {
                    ans++;
                }
            } else {
                if (charArray[i] == '1') {
                    ans++;
                }
            }
        }
        return ans;
    }
}
