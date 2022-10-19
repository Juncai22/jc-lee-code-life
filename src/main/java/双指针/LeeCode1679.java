package 双指针;


import java.util.*;

/**
 * 1679. K 和数对的最大数目
 * LeeCode 1679
 * 难度 ： 中等
 */
public class LeeCode1679 {

    public static void main(String[] args) {

    }

    public static int maxOperations(int[] nums, int k) {
        int ans = 0;
        //Hash表，以map集合一个是数字一个是数量
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //for循环后进行while循环致使数字全部清空
        for (Integer integer : map.keySet()) {
            while ((map.containsKey(k - integer) && map.get(k - integer) > 0 ) && (map.containsKey(integer) && map.get(integer) > 0) ) {
                if (map.get(k - integer) -1 >= 0) {
                    map.put(k - integer, map.get(k - integer) - 1);
                }
                if (map.get(integer) -1 >= 0) {
                    map.put(integer, map.get(integer) - 1);
                    ans++;
                }

            }
        }
        //返回
        return ans;
    }

    //双指针
    public int maxOperations2(int[] nums, int k) {
        int ans = 0;
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int L = nums[l], R = nums[r];
            if (L + R == k) {
                ans++;
                l++;
                r--;
            } else if (L + R > k) {
                r--;
            } else {
                l++;
            }
        }
        return ans;
    }

}
