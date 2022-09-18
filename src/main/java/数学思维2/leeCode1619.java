package 数学思维2;


import java.util.Arrays;

/**
 * 1619. 删除某些元素后的数组均值
 * LeeCode 1619
 * 难度 ： 简单
 */
public class leeCode1619 {


    public double trimMean(int[] arr) {
        double ans = 0;
        Arrays.sort(arr);
        for (int i = arr.length / 20; i < arr.length * 19 / 20; i++) {
            ans += arr[i];

        }
        return ans / (arr.length * 9 / 10);
    }
}
