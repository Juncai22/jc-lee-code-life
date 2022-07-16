package 数学思维;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 989. 数组形式的整数加法
 * LeeCode 989
 * 难度 ： 简单
 */
public class LeeCode989 {

    public static void main(String[] args) {
        int[] num = {9, 9, 9, 9, 9, 9, 9, 9, 9};
        int k = 1;
        List<Integer> list = addToArrayForm(num, k);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }

    public static List<Integer> addToArrayForm(int[] num, int k) {
        //首先设置返回结果
        List<Integer> res = new ArrayList<Integer>();
        int n = num.length;
        //将k与num加起来，但是在数组中相加
        for (int i = n - 1; i >= 0; --i) {
            int sum = num[i] + k % 10;
            k /= 10;
            if (sum >= 10) {
                k++;
                sum -= 10;
            }
            res.add(sum);
        }
        //如果k>num那么继续加k的值
        while (k > 0) {
            res.add(k % 10);
            k /= 10;
        }
        //使用反转
        Collections.reverse(res);
        return res;
    }
}
