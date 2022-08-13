package 数学思维2;


import java.util.ArrayList;
import java.util.List;

/**
 * 2155. 分组得分最高的所有下标
 * LeeCode 2155
 * 难度 ： 中等
 */
public class LeeCode2155 {

    public static void main(String[] args) {
        int[] temp  = {0,0,1,0};
        List<Integer> list = maxScoreIndices2(temp);
    }

    //暴力解决 —————— 超出时间限制
    public List<Integer> maxScoreIndices(int[] nums) {
        //首先提出答案
        List<Integer> ans = new ArrayList<>();
        int[] temp = new int[nums.length + 1];
        int max = 0;

        //两个for循环
        for (int i = 0; i <= nums.length; i++) {

            for (int j = 0; j < nums.length; j++) {
                //进行逐级判断
                if (j < i && nums[j] == 0) {
                    temp[i]++;
                } else if (j >= i && nums[j] == 1) {
                    temp[i]++;
                }
            }
            max = Math.max(max, temp[i]);
        }
        //进行答案添加
        for (int i = 0; i < temp.length; i++) {
            if (max == temp[i]) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static List<Integer> maxScoreIndices2(int[] nums) {
        //加法
        int presum = 0, hisMax = 0;
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                presum += 1;
                if (presum > hisMax) {
                    hisMax = presum;
                    ans.clear();
                    ans.add(i + 1);
                } else if (presum == hisMax) {
                    ans.add(i + 1);
                }
            } else presum -= 1;
        }
        return ans;
    }
}
