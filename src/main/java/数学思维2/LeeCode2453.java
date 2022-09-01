package 数学思维2;


import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * LCS 02. 完成一半题目
 * LeeCode 2453
 * 难度 ： 简单
 */
public class LeeCode2453 {

    public int halfQuestions(int[] questions) {
        int[] temp = new int[1001];
        int ans = temp.length;
        int x = 0;
        for (int question : questions) {
            temp[question]++;
        }
        Arrays.sort(temp);
        for (int i = temp.length - 1; i >= 0; i--) {
            x += temp[i];
            if (x >= questions.length / 2) {
                ans -= i;
                break;
            }
        }
        return ans;
    }
}
