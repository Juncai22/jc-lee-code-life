package 二分查找法;


/**
 * 240. 搜索二维矩阵 II
 * LeeCode 240
 * 难度 ： 中等
 */
public class LeeCode240 {

    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(searchMatrix(matrix, -20));

    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            int l = 0;
            int r = matrix[0].length - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (ints[mid] == target) return true;
                if (ints[mid] > target) r = mid - 1;
                else l = mid;
            }
        }
        return false;
    }
}
