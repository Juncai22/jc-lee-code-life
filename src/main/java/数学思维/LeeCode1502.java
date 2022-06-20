package 数学思维;

import java.util.Arrays;

/**
 * 1502. 判断能否形成等差数列
 * LeeCode 1502
 * 难度 ： 简单
 */
public class LeeCode1502 {

    public static void main(String[] args) {
        int[] arr = {3,5,1};
        boolean b = canMakeArithmeticProgression(arr);
        System.out.println(b);
    }


    public static boolean canMakeArithmeticProgression(int[] arr) {
        //先进行排序
        Arrays.sort(arr);
        //在外面制造全局变量
        boolean b = false;
        if (arr.length == 1 || arr.length == 2){
            return true;
        }
        //算出所需要的等差的数据
        int i1 = arr[1] - arr[0];
        for (int i = 2;i < arr.length;i++){
            //就如此循环搜寻得到的差距是否与前两个差距相等
            b = i1 == arr[i] - arr[i - 1];
            //如果是true继续，如果是false就直接返回
            if (b){
            }else{
                return b;
            }
        }
        return b;
    }
}
