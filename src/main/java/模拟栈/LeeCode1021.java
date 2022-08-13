package 模拟栈;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 1021. 删除最外层的括号
 * LeeCode 1021
 * 难度 ： 简单
 */
public class LeeCode1021 {

    public String removeOuterParentheses(String s) {
        StringBuffer res = new StringBuffer();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                res.append(c);
            }
            if (c == '(') {
                stack.push(c);
            }
        }
        return res.toString();

    }
}
