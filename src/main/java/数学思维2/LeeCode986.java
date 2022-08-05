package 数学思维2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 986. 区间列表的交集
 * LeeCode 986
 * 难度 ： 中等
 */
public class LeeCode986 {

    public static void main(String[] args) {
//        int[][] firstList = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
//        int[][] secondList = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        int[][] firstList = {{14, 16}};
        int[][] secondList = {{7, 13}, {16, 20}};
        int[][] ints = intervalIntersection(firstList, secondList);
        System.out.println(ints);
    }

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> list = new ArrayList<>();
        int m = firstList.length;
        int n = secondList.length;
        int i = 0;
        int j = 0;
        while(i < m && j < n){
            int [] tmp = new int[2];
            int a = firstList[i][0];
            int b = firstList[i][1];
            int x = secondList[j][0];
            int y = secondList[j][1];
            tmp[0] = Math.max(a,x);
            tmp[1] = Math.min(b,y);
            if(tmp[1] >= tmp[0])
                list.add(tmp);
            if(y >= b){
                i++;
            }
            else{
                j++;
            }
        }
        return list.toArray(new int[list.size()][]);

    }
}
