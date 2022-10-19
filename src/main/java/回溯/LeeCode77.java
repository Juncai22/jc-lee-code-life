package 回溯;


import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 * LeeCode 77
 * 难度 ： 中等
 */
public class LeeCode77 {

    public static void main(String[] args) {
        combine(4,2);
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        comBineTohuiSuo(ans, list, n, k, 1);
        return ans;
    }

    private static void comBineTohuiSuo(List<List<Integer>> ans, List<Integer> list, int n, int k, int m) {
        if (list.size() == k) {
            List<Integer> temp = new ArrayList<>(list);
            ans.add(temp);
            return;
        }

        for (int i = m; i <= n; i++) {
            List<Integer> temp = new ArrayList<>(list);
            temp.add(i);
            comBineTohuiSuo(ans, temp, n, k, ++m);
        }
    }
}
