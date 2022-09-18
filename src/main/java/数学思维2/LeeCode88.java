package 数学思维2;


import java.util.Arrays;
import java.util.Hashtable;
import java.util.TreeSet;

/**
 * 88. 合并两个有序数组
 * LeeCode 88
 * 难度 ： 简单
 */
public class LeeCode88 {


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i =m ;i< nums1.length;i++){
            nums1[i] = nums2[--n];
        }
        Arrays.sort(nums1);
    }
}
