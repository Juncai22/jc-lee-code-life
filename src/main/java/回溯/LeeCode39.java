package 回溯;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * 39. 组合总和
 * LeeCode 39
 * 难度 ： 中等
 */
public class LeeCode39 {

    public static void main(String[] args) {
        combinationSum(new int[]{2, 3, 6, 7}, 7);
    }

    //回溯法
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int candidate : candidates) {
            //首相1进行初次的定义
            if (target - candidate > 0) {
                List<Integer> list = new ArrayList<>();
                list.add(candidate);
                comBinGrand(res, target - candidate, candidates, list);
            } else if (target - candidate == 0) {
                List<Integer> list = new ArrayList<>();
                list.add(candidate);
                res.add(list);
            }
        }
        return res;
    }

    //进行方法的回溯
    private static void comBinGrand(List<List<Integer>> res, int target, int[] candidates, List<Integer> list) {
        for (int candidate : candidates) {
            List<Integer> copy = new ArrayList<>(list);
            if (target - candidate > 0) {
                copy.add(candidate);
                comBinGrand(res, target - candidate, candidates, copy);
            } else if (target - candidate == 0) {
                //进行查重，是否有多次相同的情况
                copy.add(candidate);
                Collections.sort(copy);
                //进行是否相同的汇报
                boolean sames = false;
                for (List<Integer> re : res) {
                    boolean same = true;
                    if (re.size() == copy.size()) {
                        for (int i = 0; i < re.size(); i++) {
                            if (!Objects.equals(re.get(i), copy.get(i))) {
                                same = false;
                                break;
                            }
                        }
                    } else same = false;
                    if (same) {
                        sames = true;
                        break;
                    }
                }
                if (!sames) res.add(copy);
            }
        }
    }
}
