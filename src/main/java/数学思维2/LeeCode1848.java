package 数学思维2;


import java.util.ArrayList;
import java.util.List;

/**
 * 1848. 到目标元素的最小距离
 * LeeCode 1848
 * 难度 ： 简单
 */
public class LeeCode1848 {

    public int getMinDistance(int[] number, int target, int index) {
        for (int i = index, j = index; ; i--, j++)
            if ((i >= 0 && number[i] == target) || (j < number.length && number[j] == target))
                return index - i;
    }
}
