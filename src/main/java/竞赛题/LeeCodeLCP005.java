package 竞赛题;

import java.util.LinkedList;
import java.util.List;

public class LeeCodeLCP005 {

    public static void main(String[] args) {
        int maxValue = Integer.MAX_VALUE;
        System.out.println(maxValue);
    }


    public int[][] sandyLandManagement(int size) {
        List<int[]> temp = new LinkedList<>();
        temp.add(new int[]{1, 1});
        for (int i = 2; i <= size; i++) {
            int[] t = new int[]{i, 1};
            int[] r = new int[]{i, 2 * i - 1};
            temp.add(t);
            temp.add(r);
        }
        return temp.toArray(new int[0][]);
    }
}
