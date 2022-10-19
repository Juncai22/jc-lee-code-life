package BFS深度优先;


import java.util.*;
import java.util.concurrent.DelayQueue;

/**
 * 1162. 地图分析
 * LeeCode 1162
 * 难度 ： 中等
 */
public class LeeCode1162 {

    public static void main(String[] args) {
        int[][] grid = {{1,1,1,0,0,0,0,0,1,1,1,1,0,0,0,0,0,1,0,0},{1,1,0,1,0,1,1,1,1,1,1,1,0,1,0,0,0,1,1,1},{0,0,1,1,0,1,0,0,1,0,1,1,1,1,1,1,0,0,0,0},{0,0,1,1,0,0,0,1,1,1,1,0,1,1,1,0,0,1,0,1},{1,0,1,1,0,1,1,1,0,1,0,1,0,1,1,0,1,0,1,0},{0,0,1,1,0,1,0,1,0,0,0,0,0,0,0,1,0,0,0,1},{0,0,0,1,0,0,1,1,0,0,1,1,1,1,0,0,0,0,1,0},{1,0,0,1,0,1,1,0,0,1,0,0,1,0,1,1,1,0,0,1},{0,1,0,1,1,0,0,1,1,1,1,1,0,0,1,0,1,0,0,0},{1,0,1,0,0,0,0,0,0,1,1,1,0,0,1,0,1,0,1,0},{0,1,1,0,1,1,1,0,0,0,1,0,0,0,1,0,0,0,0,0},{0,0,1,1,1,1,1,1,1,0,0,0,1,0,0,0,0,0,1,0},{0,0,1,1,0,0,1,1,1,1,1,1,1,0,1,0,1,0,0,0},{0,1,0,1,0,0,0,1,1,1,0,0,0,1,1,0,0,1,0,1},{1,0,0,0,1,0,1,0,1,1,1,1,0,0,1,0,0,0,1,1},{0,1,0,0,1,0,0,0,0,1,0,0,0,0,1,0,1,0,0,1},{0,1,0,1,0,0,0,1,0,1,1,1,1,1,0,0,0,0,0,1},{1,1,1,0,0,1,0,1,1,0,0,0,0,1,1,0,0,0,1,0},{1,1,1,1,1,1,0,1,0,0,0,1,1,1,1,0,0,1,0,1},{0,0,0,1,1,0,1,0,1,0,1,0,1,1,0,1,0,0,0,0}};
        maxDistance(grid);
    }

    public static int maxDistance(int[][] grid) {
        //定义一个队列先进先出，保证小的周围逐级增大
        Deque<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) queue.add(new int[]{i, j});
            }
        }

        //如果全为1，那么返回 -1
        if (queue.size() == grid.length * grid[0].length) return -1;

        //进行数字遍历
        while (queue.size() != 0) {
            int[] poll = queue.poll();
            bocollege(grid, poll[0], poll[1], queue);
        }
        int max = 0;
        //查找最大值
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, grid[i][j]);
            }
        }
        //因为是从1开始，所以要减一
        return max - 1;
    }

    private static void bocollege(int[][] grid, int i, int j, Queue<int[]> queue) {
        if ((i + 1) < grid.length && grid[i + 1][j] == 0) {
            grid[i + 1][j] = grid[i][j] + 1;
            queue.add(new int[]{i + 1, j});
        }
        if ((j + 1) < grid[0].length && grid[i][j + 1] == 0) {
            grid[i][j + 1] = grid[i][j] + 1;
            queue.add(new int[]{i, j + 1});
        }
        if ((i - 1) >= 0 && grid[i - 1][j] == 0) {
            grid[i - 1][j] = grid[i][j] + 1;
            queue.add(new int[]{i - 1, j});
        }
        if ((j - 1) >= 0 && grid[i][j - 1] == 0) {
            grid[i][j - 1] = grid[i][j] + 1;
            queue.add(new int[]{i, j - 1});
        }
    }
}
