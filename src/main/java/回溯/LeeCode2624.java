package 回溯;


import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 081. 允许重复选择元素的组合
 * LeeCode 2624
 * 难度 ： 中等
 */
public class LeeCode2624 {


    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        combinationSum(arr, 7);
    }

    static List<List<Integer>> ans = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (target <= 0) return ans;
        dfs(0, candidates, target, new ArrayList<>());
        return ans;
    }

    static void dfs(int i, int[] candidates, int target, List<Integer> lanb) {
        if (target < 0 || i > candidates.length - 1) return;
        if (target == 0) {
            ans.add(new ArrayList<>(lanb));
            return;
        }
        lanb.add(candidates[i]);
        dfs(i, candidates, target - candidates[i], lanb);
        lanb.remove(lanb.size() - 1);
        dfs(i + 1, candidates, target, lanb);
    }
}
