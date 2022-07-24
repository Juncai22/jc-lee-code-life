package DFS深度优先搜索;


/**
 * 695. 岛屿的最大面积
 * LeeCode 695
 * 难度 ： 中等
 */
public class LeeCode695 {

    public static void main(String[] args) {
        int[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        System.out.println(maxAreaOfIsland(grid));

    }

    //深度dfs遍历
    public static int maxAreaOfIsland(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int i1 = 0; i1 < grid[0].length; i1++) {
                int temps = 0;
                int temp = dfsGrid(grid, i, i1, temps);
                count = Math.max(count,temp);
            }
        }
        return count;
    }

    //进行递归遍历
    public static int dfsGrid(int[][] grid,int i,int j,int count){
        if(i < 0 || i >= grid.length ||
                j < 0 || j >= grid[0].length || grid[i][j] != 1){
            return 0;
        }
            grid[i][j] = 2;
            count++;
        //进行递归
        count = Math.max(count,dfsGrid(grid,i+1,j,count));
        count = Math.max(count,dfsGrid(grid,i-1,j,count));
        count = Math.max(count,dfsGrid(grid,i,j+1,count));
        count = Math.max(count,dfsGrid(grid,i,j-1,count));

        return count;
    }
}
