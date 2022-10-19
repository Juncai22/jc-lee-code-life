package 模拟栈;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 1441. 用栈操作构建数组
 * LeeCode 1441
 * 难度 ： 中等
 */
public class LeeCode1441 {

    public List<String> buildArray(int[] target, int n) {
        String push = "Push";
        String pop = "Pop";
        List<String> res = new LinkedList<>();
        int index = 0;
        for (int i = 1; i <= target[target.length - 1]; i++) {
            if (target[index] == i) {
                res.add(push);
                index++;
            } else {
                res.add(push);
                res.add(pop);
            }

        }
        return res;
    }
}
