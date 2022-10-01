package 回溯;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 241. 为运算表达式设计优先级
 * LeeCode 241
 * 难度 ： 中等
 */
public class LeeCode241 {


    public Map<String, List<Integer>> map = new HashMap<>();

    // 记录已经计算出来的字符串对应的值，避免重复计算。
    public List<Integer> diffWaysToCompute(String input) {

        if(map.containsKey(input)) return map.get(input);
        List<Integer> list = new ArrayList<>();
        int len = input.length();
        for(int i = 0; i < len; i++) {
            char c = input.charAt(i);
            if(c == '+' || c == '-' || c == '*') {  // 出现运算符号，递归求解前半段和后半段。
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1, input.length()));
                // -1   =>  left:[[0]]  right:[[1]]

                for(int l : left) {
                    for(int r : right) {
                        switch(c) {
                            case '+':
                                list.add(l + r);
                                break;
                            case '-':
                                list.add(l - r);
                                break;
                            case '*':
                                list.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if(list.size() == 0) list.add(Integer.valueOf(input));
        // 单独一个数字的情况 (可能出现多位数)
        map.put(input, list);
        return list;

//        if (map.containsKey(input)) return map.get(input);
//        List<Integer> ans = new ArrayList<>();
//        for (int i = 0; i < input.length(); i++) {
//            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
//                List<Integer> left = diffWaysToCompute(input.substring(0, i));
//                List<Integer> right = diffWaysToCompute(input.substring(i + 1, input.length()));
//
//                for (Integer integer : left) {
//                    for (Integer integer1 : right) {
//                        switch (input.charAt(i)){
//                            case '+' : ans.add(integer + integer1); break;
//                            case '-' : ans.add(integer - integer1); break;
//                            case '*' : ans.add(integer * integer1); break;
//                        }
//                    }
//                }
//            }
//        }
//        if(ans.size() == 0) ans.add(Integer.valueOf(input));
//        // 单独一个数字的情况 (可能出现多位数)
//        map.put(input, ans);
//        return ans;
    }
}
