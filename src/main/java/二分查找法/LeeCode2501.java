package 二分查找法;


/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * LeeCode 2501
 * 难度 ： 简单
 */
public class LeeCode2501 {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int count = 0;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target)
                right = mid;
            if (nums[mid] < target)
                left = mid + 1;
        }
        while (left < nums.length && nums[left++] == target)
            count++;
        return count;
    }
}
