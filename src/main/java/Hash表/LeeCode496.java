package Hash表;


import java.util.HashMap;
import java.util.Stack;

/**
 * 496. 下一个更大元素 I
 * LeeCode 496
 * 难度 ： 简单
 */
public class LeeCode496 {

    public static void main(String[] args) {
        int[] nums1 = {1,3,4,2};
        int[] nums2 = {4,1,2};
        int[] ints = nextGreaterElement(nums2, nums1);
        System.out.println(ints);
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<Integer>();
        HashMap<Integer, Integer> hasMap = new HashMap<Integer, Integer>();

        int[] result = new int[nums1.length];

        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                hasMap.put(stack.pop(), num);
            }
            stack.push(num);
        }

        for (int i = 0; i < nums1.length; i++) result[i] = hasMap.getOrDefault(nums1[i], -1);

        return result;
    }
}
