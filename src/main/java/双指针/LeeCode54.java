package 双指针;


import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * LeeCode 54
 * 难度 ： 中等
 */
public class LeeCode54 {

    public static void main(String[] args) {
//        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix = {{3}, {2}};
        List<Integer> list = spiralOrder(matrix);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        //定义上层的左指针，和左边的的上指针
        int m1 = 0, n1 = 0;
        //定义下层的右指针，和右边的上指针
        int m2 = matrix.length - 1, n2 = matrix[0].length - 1;
        //定义是否上下，是否左右
        short chance = 0, check = 0;
        //结果
        List<Integer> ans = new ArrayList<>();
        //定义遍历的位置所在
        int m3 = 0, n3 = 0;

        //当结果的数量和总数量相同，则返回
        while (ans.size() != matrix.length * matrix[0].length) {
            //左上往右上
            if (chance == 0 && check == 0) {
                ans.add(matrix[m3][n3]);
                n3++;
                if (n3 > n2) {
                    m1++;
                    m3++;
                    n3--;
                    chance = 1;
                    check = 1;
                }
                //右下往左下
            } else if (chance == 0 && check == 1) {
                ans.add(matrix[m3][n3]);
                n3--;
                if (n3 < n1) {
                    m2--;
                    m3--;
                    n3++;
                    chance = 1;
                    check = 0;
                }
                //右上往右下
            } else if (chance == 1 && check == 0) {
                ans.add(matrix[m3][n3]);
                m3--;
                if (m3 < m1) {
                    n1++;
                    n3++;
                    m3++;
                    chance = 0;
                    //左上往左下
                }
            }else if (chance == 1 && check == 1) {
                    ans.add(matrix[m3][n3]);
                    m3++;
                    if (m3 > m2) {
                        n2--;
                        n3--;
                        m3--;
                        chance = 0;
                    }
                }
            }

        return ans;
    }
}

