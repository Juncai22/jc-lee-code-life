package Hash表;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 442. 数组中重复的数据
 * LeeCode 442
 * 难度 ： 中等
 */
public class LeeCode442 {

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> duplicates2 = findDuplicates2(nums);
        System.out.println(duplicates2);
    }


    //hash表解法
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int num : nums) {
            if (hashSet.contains(num)){
                ans.add(num);
            }else {
                hashSet.add(num);
            }
        }

        return ans;
    }
    //靠数组交换解法
    public static List<Integer> findDuplicates2(int[] nums) {
        //因为是小于数字的，所以肯定就有总共那么多的数字，如果数字占有了莫须有的位置，那么就会表示出错。则出错的就是所需值
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (nums[i] - 1 != i) {
                ans.add(nums[i]);
            }
        }
        return ans;
    }

    public static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}
