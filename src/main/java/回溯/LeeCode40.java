package 回溯;


import java.util.*;

/**
 * 40. 组合总和II
 * LeeCode 40
 * 难度 ： 中等
 */
public class LeeCode40 {
    public static void main(String[] args) {
        LeeCode40 leeCode40 = new LeeCode40();
        int[] candiadtes = {2, 3, 5};
        leeCode40.combinationSum2(candiadtes, 8);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();

        combinationToWord(res, list, candidates, target, 0);

        return res;
    }

    private void combinationToWord(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int m) {
        if (target == 0) {
            List<Integer> temp = new ArrayList<>(list);
            res.add(temp);
            return;
        } else if (target < 0) {
            return;
        }


        for (int i = m; i < candidates.length; i++) {
            if (i > m && candidates[i] == candidates[i - 1]) continue;
            List<Integer> temp = new ArrayList<>(list);
            temp.add(candidates[i]);
            combinationToWord(res, temp, candidates, target - candidates[i], i + 1);
        }
    }
}
//    List<List<Integer>> list = new ArrayList<>();
//    List<Integer> path = new ArrayList<>();
//
//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        Arrays.sort(candidates);
//        dfs(candidates, target, 0);
//        return list;
//    }
//
//    private void dfs(int[] candidates, int target, int index) {
//        if (target == 0) {
//            list.add(new ArrayList<>(path));
//            return;
//        }
//        for (int i = index; i < candidates.length; i++) {
//            if (candidates[i] <= target) {
//                if (i > index && candidates[i] == candidates[i - 1]) {
//                    continue;
//                }
//                path.add(candidates[i]);
//                dfs(candidates, target - candidates[i], i + 1);
//                path.remove(path.size() - 1);
//            }
//        }

