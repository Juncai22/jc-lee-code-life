package 数学思维;


import java.util.ArrayList;
import java.util.List;

/**
 * 73. 矩阵置零
 * LeeCode 73
 * 难度 ： 中等
 */
public class LeeCode73 {

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);
    }


    public static void setZeroes(int[][] matrix) {
        int l = matrix.length;
        int w = matrix[0].length;
        List<Integer> wi = new ArrayList<>();
        List<Integer> li = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < w; j++) {
                if (matrix[i][j] == 0) {
                    li.add(i);
                    wi.add(j);
                }
            }
        }
        for (int i = 0; i < li.size(); i++) {
            for (int j = 0; j < w; j++) {
                matrix[li.get(i)][j] = 0;
            }
        }
        for (int i = 0; i < wi.size(); i++) {
            for (int j = 0; j < l; j++) {
                matrix[j][wi.get(i)] = 0;
            }
        }
    }
}
