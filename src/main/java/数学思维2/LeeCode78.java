package 数学思维2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 78. 子集
 * LeeCode 78
 * 难度 ： 中等
 */
public class LeeCode78 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = subsets(nums);
        for (List<Integer> subset : subsets) {
            System.out.println();
            for (Integer integer : subset) {
                System.out.print(integer);
            }
        }

    }


    public static List<List<Integer>> subsets(int[] nums) {
        //首先进行list开始来
        List<List<Integer>> list = new ArrayList<>();
        //进行初始化
        List<Integer> temp = new ArrayList<>();
        list.add(temp);
        for (int i = 0; i < nums.length; i++) {
            int all = list.size();
            for (int j = 0; j < all; j++) {
                //制造一个新的list进行在此之上开始的保存
                List<Integer> si = new ArrayList<>(list.get(j));
                si.add(nums[i]);
                list.add(si);
            }
        }
        //返回答案
        return list;
    }
}
