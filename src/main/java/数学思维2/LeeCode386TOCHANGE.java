package 数学思维2;


import java.util.ArrayList;
import java.util.List;

/**
 * 386. 字典序排数
 * LeeCode 386
 * 难度 ： 中等
 */
public class LeeCode386TOCHANGE {

    public static void main(String[] args) {
        lexicalOrder(188);
    }


    public static List<Integer> lexicalOrder(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 1; i < 10; i++)
            dfs(n, i, res);
        return res;
    }

    private static void dfs(int n, int target, List<Integer> list) {
        if (target > n) return;
        list.add(target);
        target *= 10;
        for (int i = 0; i < 10; i++)
            dfs(n, target + i, list);
    }


}
