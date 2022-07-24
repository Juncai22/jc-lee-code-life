package 固定划窗;


import java.util.Arrays;
import java.util.HashSet;

/**
 * 904. 水果成篮
 * LeeCode 904
 * 难度 ： 中等
 */
public class LeeCode904 {

    public static void main(String[] args) {
        int[] fruits = {0,1,2,2};
        int i = totalFruit2(fruits);
        System.out.println(i);
    }


    //方法一，暴力解法
    public static int totalFruit(int[] fruits) {
        //首先定义最终答案，和临时答案
        int ans = 0;
        int ansm = 0;
        //如果长度没到2，直接返回1
        if (fruits.length < 2){
            return 1;
        }
        //双重for循环来得到答案
        for (int i = 0;i < fruits.length;i++){
            HashSet<Integer> hashSet = new HashSet<>();
            //对比答案，并获得答案
            ans = Math.max(ansm, ans);
            ansm = 0;
            int upEnd = 0;
            for (int j = i; j < fruits.length; j++) {
                    if (hashSet.contains(fruits[j])) {
                        ansm++;
                    }else {
                        if (upEnd != 2) {
                            ansm++;
                            hashSet.add(fruits[j]);
                            upEnd++;
                        }else{
                            break;
                  }
               }
            }
        }
        //返回答案
        return ans;
    }


    //方法2，滑动窗口
    public static int totalFruit2(int[] fruits) {
        if(fruits.length == 1 && fruits.length == 2) {
            return fruits.length;
        }
        int basket1 = -1, basket2 = -1; //记录当前篮子里的水果
        int sum = 0;
        int curFruit = -1, curFruitLoc = 0; //记录当前的水果，和当前水果的起始位置
        int subSum = 0;
        int j = 0; // 记录篮子起始位置
        for (int i = 0; i < fruits.length; ++i) {
            if (fruits[i] == basket1 || fruits[i] == basket2)
            {
                if (fruits[i] != curFruit) {// 记录在篮子里的连续最近，在更换篮子里水果的时候使用
                    curFruit = fruits[i];
                    curFruitLoc = i;
                }
            }
            else {
                j = curFruitLoc;
                curFruitLoc = i;
                if (basket1 == curFruit) { // 更新水果篮
                    basket2 = fruits[i];
                    curFruit = basket2;

                }
                else {
                    basket1 = fruits[i];
                    curFruit = basket1;
                }
            }
            subSum = (i - j + 1); // 计算最长子序列
            sum = Math.max(sum, subSum);
        }
        return sum;
    }
}
