package 回溯;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 46. 全排列
 * LeeCode 46
 * 难度 ： 中等
 */
public class LeeCode46 {

    public static void main(String[] args) {
        permute(new int[]{1, 2, 3});
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        toChackGroud(res, list, nums, set);
        return res;
    }

    private static void toChackGroud(List<List<Integer>> res, List<Integer> list, int[] nums, HashSet<Integer> set) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
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
