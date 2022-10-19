package 回溯;


import java.util.*;

/**
 * 870. 优势洗牌
 * LeeCode 870
 * 难度 ： 中等
 */
public class LeeCode870 {

    public static void main(String[] args) {
        int[] nums = {12,24,8,32};
        int[] nums2 = {13,25,32,11};
        advantageCount(nums,nums2);
    }

    public static int[] advantageCount(int[] nums1, int[] nums2) {
        //先进行各自排序，并且将下表把偶才能
        Arrays.sort(nums1);
        int[] ans = new int[nums1.length];
        Arrays.fill(ans, -1);
        Queue<Integer> queue = new LinkedList<>();

        int[][] index = new int[nums2.length][2];

        for (int i = 0; i < index.length; i++) {
            index[i][0] = nums2[i];
            index[i][1] = i;
        }

        Arrays.sort(index, ((o1, o2) -> {
            return o1[0] - o2[0];
        }));

        //查看如果大于变替换，小于变保存下标
        for (int i = 0, m = 0; i < nums1.length; ) {
            if (nums1[i] > index[m][0]) ans[index[m++][1]] = nums1[i++];
            else {
                queue.add(i);
                i++;
            }
        }
        //保存的下标存入
        for (int i = 0; i < nums1.length; i++) {
            if (ans[i] == -1 && queue.size() >= 1) {
                ans[i] = nums1[queue.poll()];
            }
        }
        return ans;
    }
}
