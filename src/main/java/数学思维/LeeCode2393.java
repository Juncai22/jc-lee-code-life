package 数学思维;

public class LeeCode2393 {

    //把数组斜过来45度，便可以得到一个树，根据树，以高为左子树，横为右子树。可以得到答案
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //查看数组是否正确
        if(matrix == null || matrix.length == 0) {
            return false;
        }
        //设置高和宽
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = n - 1;
        //进行常量计算
        while(row < m && col >= 0) {
            if(matrix[row][col] > target) {
                col--;
            }else if(matrix[row][col] < target) {
                row++;
            }else {
                //返回true
                return true;
            }
        }
        //返回false
        return false;
    }
}
