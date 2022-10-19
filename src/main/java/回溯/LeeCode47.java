package 回溯;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

/**
 * 47. 全排列 II
 * LeeCode 47
 * 难度 ： 中等
 */
public class LeeCode47 {



    //回溯
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        toChackGroud(res, list, nums, set);
        return res;
    }

    private static void toChackGroud(List<List<Integer>> res, List<Integer> list, int[] nums, HashSet<Integer> set) {
        if (list.size() == nums.length) {
            boolean same = false;
            for (List<Integer> re : res) {
                boolean besanme = false;
                for (int i = 0; i < re.size(); i++) {
                    if (Objects.equals(re.get(i), list.get(i)) && i == re.size() - 1) {
                        besanme = true;
                        break;
                    }
                    if (!Objects.equals(re.get(i), list.get(i))) break;
                }
                if (besanme){
                    same = true;
                }
            }
            if (!same) res.add(new ArrayList<>(list));;
        }
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(i)) continue;
            HashSet<Integer> tempSet = new HashSet<>(set);
            tempSet.add(i);
            ArrayList<Integer> tempList = new ArrayList<>(list);
            tempList.add(nums[i]);
            toChackGroud(res, tempList, nums, tempSet);
        }
    }
}
