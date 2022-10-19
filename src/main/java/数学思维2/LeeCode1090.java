package 数学思维2;


import java.util.Arrays;
import java.util.HashMap;

/**
 * 1090. 受标签影响的最大值
 * LeeCode 1090
 * 难度 ： 中等
 */
public class LeeCode1090 {


    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        //定义基本指针还有答案的数字
        int numNow = 0;
        int ans = 0;
        //进行两个数组之间的合并操作
        int[][] valueAndLable = new int[values.length][2];
        for (int i = 0; i < valueAndLable.length; i++) {
            valueAndLable[i][0] = values[i];
            valueAndLable[i][1] = labels[i];
        }
        //进行依次排序
        Arrays.sort(valueAndLable, ((o1, o2) -> {
            return o1[0] - o2[0];
        }));

        //以map计算次数，然后查看正确与否
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = valueAndLable.length - 1; i >= 0; i--) {
            map.put(valueAndLable[i][1], map.getOrDefault(valueAndLable[i][1], 0) + 1);
            if (map.get(valueAndLable[i][1]) > useLimit) {
                map.put(valueAndLable[i][1], map.getOrDefault(valueAndLable[i][1], 0) - 1);
            } else {
                ans += valueAndLable[i][0];
                numNow++;
            }

            if (numNow == numWanted) break;
        }
        //返回
        return ans;
    }
}
