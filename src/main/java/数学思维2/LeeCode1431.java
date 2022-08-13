package 数学思维2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1431. 拥有最多糖果的孩子
 * LeeCode 1431
 * 难度 ： 简单
 */
public class LeeCode1431 {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;

        for (int candy : candies) {
            max = Math.max(candy, max);
        }

        List<Boolean> ans = new ArrayList<>();

        for (int candy : candies) {
            if (candy + extraCandies >= max) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }

        return ans;
    }
}
