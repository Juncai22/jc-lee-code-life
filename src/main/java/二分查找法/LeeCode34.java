package 二分查找法;


/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * LeeCode 34
 * 难度 ： 中等
 */
public class LeeCode34 {

    public static void main(String[] args) {
        Integer a1 = 10;
        getInt(a1);
        System.out.println(a1);
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        res[0] = binarySearch(nums, target, true);
        res[1] = binarySearch(nums, target, false);
        return res;
    }

    //leftOrRight为true找左边界 false找右边界
    public int binarySearch(int[] nums, int target, boolean leftOrRight) {
        int res = -1;
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target < nums[mid])
                right = mid - 1;
            else if (target > nums[mid])
                left = mid + 1;
            else {
                res = mid;
                //处理target == nums[mid]
                if (leftOrRight)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        return res;
    }

    public static void getInt(Integer a1){
        a1 += 10;
    }
}
