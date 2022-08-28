package 数学思维2;


/**
 * 剑指 Offer 29. 顺时针打印矩阵
 * LeeCode 2465
 * 难度 ： 简单
 */
public class LeeCode2465 {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] ints = spiralOrder(matrix);

    }

    public static int[] spiralOrder(int[][] matrix) {
        //现在指针的高度
        int h = 0;
        //现在指针的宽度
        int w = 0;
        //现在的个数
        int i = 0;
        //如果为0，则直接返回新的空数组；
        if (matrix.length == 0) {
            return new int[0];
        }
        int hlength = matrix.length;
        int wlength = matrix[0].length;

        int[] ans = new int[hlength * wlength];
        while (i != hlength * wlength) {
            //先进行右while循环，并将已走过的数字改变为-10000
            while (w < wlength && matrix[h][w] != -10000) {
                ans[i] = matrix[h][w];
                matrix[h][w] = -10000;
                i++;
                w++;
            }
            w--;
            h++;
            //第二步进行向下循环，并将已走过的数字改变为-10000
            while (h < hlength && matrix[h][w] != -10000) {
                ans[i] = matrix[h][w];
                matrix[h][w] = -10000;
                i++;
                h++;
            }
            h--;
            w--;
            //先进行左while循环，并将已走过的数字改变为-10000
            while (w >= 0 && matrix[h][w] != -10000) {
                ans[i] = matrix[h][w];
                matrix[h][w] = -10000;
                i++;
                w--;
            }
            w++;
            h--;
            //第二步进行向上循环，并将已走过的数字改变为-10000
            while (h >= 0 && matrix[h][w] != -10000) {
                ans[i] = matrix[h][w];
                matrix[h][w] = -10000;
                i++;
                h--;
            }
            h++;
            w++;
        }
        return ans;
    }
}
