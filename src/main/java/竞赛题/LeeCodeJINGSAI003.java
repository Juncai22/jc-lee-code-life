package 竞赛题;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * LEECODE杯   暴力解法
 * 003. 弹珠游戏
 * LeeCode 003
 * 难度 ： 中等
 */
public class LeeCodeJINGSAI003 {
    int[] up = {-1, 0};
    int[] down = {1, 0};
    int[] left = {0, -1};
    int[] right = {0, 1};
    String[][] chess;
    int initStep;//初始步数

    public int[][] ballGame(int num, String[] plate) {
        initStep = num;
        int m = plate.length;
        int n = plate[0].length();
        chess = new String[m][n];
        //棋盘转化
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                chess[i][j] = plate[i].charAt(j) + "";
            }
        }
        //注意四角位置除外，且只有边缘位置：上面往下，左边往右，下面往上，右边往左
        List<int[]> res = new ArrayList<>();
        //上下
        for (int i = 1; i < n - 1; i++) {
            if (get_hole(0, i, num, down)) res.add(new int[]{0, i});//上往下
            if (get_hole(plate.length - 1, i, num, up)) res.add(new int[]{plate.length - 1, i});//下往上
        }
        //左右
        for (int i = 1; i < m - 1; i++) {
            if (get_hole(i, 0, num, right)) res.add(new int[]{i, 0});
            if (get_hole(i, plate[0].length() - 1, num, left)) res.add(new int[]{i, plate[0].length() - 1});
        }
        int[][] arr = new int[res.size()][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    //x,y开始朝direct前进N步！能否进洞？
    public boolean get_hole(int x, int y, int N, int[] direct) {
        if (N == initStep && (chess[x][y].equals("E")||chess[x][y].equals("W")||chess[x][y].equals("O")))return false;
        if (x < 0 || x >= chess.length || y < 0 || y >= chess[0].length || N < 0) return false;
        //判断我当前位置
        if (chess[x][y].equals(".")) N--;
        int[] my_dir = direct;
        switch (chess[x][y]) { //竟然很少用switch
            case "O":
                if (initStep == N)//没有动
                    return false;/*x != 0 && x != chess.length - 1 && y != 0 && y != chess[0].length - 1*/
                return true;
            case "W":
                my_dir = change_to_ni(direct);
                break;
            case "E":
                my_dir = change_to_shun(direct);
                break;
        }
        return get_hole(x + my_dir[0], y + my_dir[1], N, my_dir);
    }

    //逆时针方向转动
    private int[] change_to_ni(int[] direct) {

        if (direct == up) return left;
        else if (direct == right) return up;
        else if (direct == down) return right;
        else if (direct == left) return down;
        return new int[]{};
    }

    //顺时针方向转动
    private int[] change_to_shun(int[] direct) {
        if (direct == up) return right;
        else if (direct == right) return down;
        else if (direct == down) return left;
        else if (direct == left) return up;
        return new int[]{};
    }
}
