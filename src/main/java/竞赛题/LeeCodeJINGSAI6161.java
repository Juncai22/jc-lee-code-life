package 竞赛题;


import java.util.Arrays;
import java.util.Stack;

/**
 * 6161. 从字符串中移除星号
 * LeeCode 6161
 * 难度 ： 中等
 */
public class LeeCodeJINGSAI6161 {

    public static void main(String[] args) {
        String s = removeStars("leet**cod*e");
        System.out.println(s);

    }

    public static String removeStars(String s) {
        char[] chars = s.toCharArray();
        StringBuilder ans = new StringBuilder("");
        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            if (aChar == '*' && !stack.empty()) {
                stack.pop();
            } else {
                stack.push(aChar);
            }
        }
        for (Character character : stack) {
            ans.append(character);
        }

        return String.valueOf(ans);
    }
}
