package 二分查找法;


/**
 * 1901. 寻找峰值 II
 * LeeCode 1901
 * 难度 ： 中等
 */
public class LeeCode1901TOCHANGE {


    //二分手法
    public static int[] findPeakGrid(int[][] mat) {
        //首先将基本数据拿出来
        int m = mat.length, n = mat[0].length;
        int low = 0, high = m - 1, maxIndex = 0;
        //进行二分查找
        while (low < high) {
            int mid = low + (high - low) / 2;
            maxIndex = getMaxIndex(mat[mid]);
            if (mat[mid][maxIndex] > mat[mid + 1][maxIndex]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        //查找那一高度中最大的
        maxIndex = getMaxIndex(mat[low]);
        //返回
        return new int[]{low, maxIndex};
    }

    //查找那一高度中最大的
    public static int getMaxIndex(int[] row) {
        int index = 0, maxNum = 0;
        int n = row.length;
        for (int i = 0; i < n; i++) {
            if (row[i] > maxNum) {
                maxNum = row[i];
                index = i;
            }
        }
        return index;
    }

    int max = 0;
    int[] pos = new int[]{};


    // DFS深度搜搜寻找最大值
    public int[] FindPeakGrid(int[][] mat) {
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++)
                Dfs(mat, i, j);
        }
        return pos;
    }

    public void Dfs(int[][] mat, int i, int j){
        if(i < 0 || j < 0 || i > mat.length - 1 || j > mat[0].length - 1 || mat[i][j] == -1)
            return;

        if(mat[i][j] > max){
            max = mat[i][j];
            pos = new int[]{i, j};
            return;
        }
        mat[i][j] = -1;
        Dfs(mat, i + 1, j);
        Dfs(mat, i - 1, j);
        Dfs(mat, i, j + 1);
        Dfs(mat, i, j - 1);
    }
}
