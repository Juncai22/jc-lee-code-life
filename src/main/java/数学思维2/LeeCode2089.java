package 数学思维2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2089. 找出数组排序后的目标下标
 * LeeCode 2089
 * 难度 ： 简单
 */
public class LeeCode2089 {


    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]){
                ans.add(i);
            }
        }
        return ans;
    }
}
