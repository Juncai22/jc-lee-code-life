package DP动态规划;


import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 * LeeCode 119
 * 难度 ： 简单
 */
public class LeeCode119 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add(0);
            for (int j = i; j > 0; --j) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }
}
