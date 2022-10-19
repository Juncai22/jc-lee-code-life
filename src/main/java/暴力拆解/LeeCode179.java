package 暴力拆解;


import java.util.Arrays;
import java.util.Comparator;

/**
 * 179. 最大数
 * LeeCode 179
 * 难度 ： 中等
 */
public class LeeCode179 {

    public static void main(String[] args) {
        largestNumber(new int[]{3, 30, 34, 5, 9});
    }

    public static String largestNumber(int[] nums) {
        //首先以免出现未含有的情况
        if (nums == null || nums.length == 0) {
            return "";
        }
        //定义一个新的数组
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }

        //进行新的位次的运算
        Arrays.sort(strings, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));


        //运算过后再把它合并起来
        StringBuilder stringBuilder = new StringBuilder();
        for (String st : strings) {
            stringBuilder.append(st);
        }
        //如果首位数字都为0则总数为0
        if (stringBuilder.charAt(0) == '0') {
            stringBuilder = new StringBuilder("0");
        }

        //返回
        return String.valueOf(stringBuilder);
    }
}
