package 数学思维2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 1333. 餐厅过滤器
 * LeeCode 1333
 * 难度 ： 中等
 */
public class LeeCode1333 {

    public static void main(String[] args) {
        int[][] res = {{1,4,1,40,10},{2,8,0,50,5},{3,8,1,30,4},{4,10,0,10,3},{5,1,1,15,1}};
        filterRestaurants(res, 0, 50, 10);
    }

    public static List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        //运用多次循环进行排序
        List<int[]> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        //使用if做过滤，将不满足要求的过滤掉
        for (int[] restaurant : restaurants) {
            if (veganFriendly == 1) {
                if (restaurant[3] <= maxPrice && restaurant[4] <= maxDistance && restaurant[2] == 1)
                    list.add(restaurant);
            } else {
                if (restaurant[3] <= maxPrice && restaurant[4] <= maxDistance) list.add(restaurant);
            }
        }

        //进行按规则排序
        Collections.sort(list, ((o1, o2) -> {
            if (o1[1] == o2[1]) return o2[0] - o1[0];
            return o2[1] - o1[1];
        }));

        for (int[] ints : list) {
            ans.add(ints[0]);
        }
        return ans;
    }
}
