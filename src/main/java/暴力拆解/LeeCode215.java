package 暴力拆解;


/**
 * 215. 数组中的第K个最大元素
 * LeeCode 215
 * 难度 ： 中等
 */
public class LeeCode215 {

    public int findKthLargest(int[] nums, int k) {
        int[] slots = new int[20001];
        for (int num : nums) {
            slots[num + 10000]++;
        }
        for (int i = slots.length - 1; i >= 0; i--) {
            k -= slots[i];
            if (k <= 0) {
                return i - 10000;
            }
        }
        return 0;
    }
}
