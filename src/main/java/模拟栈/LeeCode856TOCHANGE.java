package 模拟栈;


import java.util.*;

/**
 * 856. 括号的分数
 * LeeCode 856
 * 难度 ： 中等
 */
public class LeeCode856TOCHANGE {

    public static void main(String[] args) {
        scoreOfParentheses("(()(()))");
    }

    public static int scoreOfParentheses(String s) {
        Deque<Character> stack=new LinkedList<>();
        int result=0;       //返回结果
        boolean flag=true;  //在'(' 后遇到 ')'计算当前括号的深度

        for(char ch:s.toCharArray()){
            if(ch=='('){    //遇到'('进行压栈操作,允许遇到')'计算当前括号的深度
                stack.add(ch);
                flag=true;
            }
            else{
                if(flag) {      //遇到')'先判断上一次操作是不是压栈操作,是,则计算当前括号的深度,获取栈的大小
                    result += Math.pow(2,stack.size()-1);
                    flag=false;
                }
                stack.pop();    //将栈顶的'('抛出
            }
        }

        return result;
    }
}
