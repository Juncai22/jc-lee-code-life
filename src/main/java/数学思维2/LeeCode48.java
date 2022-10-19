package 数学思维2;


/**
 * 48. 旋转图像
 * LeeCode 48
 * 难度 ： 中等
 */
public class LeeCode48 {

    public static void main(String[] args) {
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        rotate(matrix);
        int n = 4;
        int i = n >> 1;
        System.out.println(i);
        int i1 = (n + 1) >> 1;
        System.out.println(i1);
    }

    public static void rotate(int[][] matrix) {
//        {
//            int n = matrix.length;
//            if (n <= 1) {
//                return;
//            }
//
//            //以中间行为界，上下行交换
//            for (int i = 0; i < n / 2; i++) {
//                for (int j = 0; j < n; j++) {
//                    int temp = matrix[i][j];
//                    matrix[i][j] = matrix[n - 1 - i][j];
//                    matrix[n - 1 - i][j] = temp;
//                }
//            }
//
//            //以主对角线为界，对称的元素交换
//            for (int i = 0; i < n; i++) {
//                for (int j = i + 1; j < n; j++) {
//                    int temp = matrix[i][j];
//                    matrix[i][j] = matrix[j][i];
//                    matrix[j][i] = temp;
//                }
//            }
        int n = matrix.length;
        for (int i = 0; i < n >> 1; i++) {   //遍历要旋转的区域
            for (int j = 0; j < (n + 1) >> 1; j++) {
                int t = matrix[i][j];   //先保存该区域的点
                matrix[i][j] = matrix[n - j - 1][i];    //把该区域下面的点旋转到该区域
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];  //把该区域右下角的点旋转到该区域下面
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];  //把该区域右边的点旋转到该区域右下角
                matrix[j][n - i - 1] = t;   //将该区域的点旋转到该区域右边
            }
        }
    }
}
