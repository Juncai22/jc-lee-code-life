package 数学思维;


import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 01.08. 零矩阵
 * LeeCode 2690
 * 难度 ： 中等
 */
public class LeeCode2690 {

    public void setZeroes(int[][] matrix) {
        List<Integer> h = new ArrayList<>();
        List<Integer> w = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    h.add(i);
                    w.add(j);
                }
            }
        }
        for (Integer integer : h) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[integer][i] = 0;
            }
        }
        for (Integer integer : w) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][integer] = 0;
            }
        }
    }
}
