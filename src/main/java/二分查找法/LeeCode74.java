package 二分查找法;


/**
 * 搜索二维矩阵
 * LeeCode 74
 * 难度 ： 中等
 */

class LeeCode74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        //解题思路：矩阵从左到右从上到下访问得到的数组是个生序列，题目需要查询目标值是否在生序列中，使用二分查找；
        //为了省掉m*n升序列的空间，需要确定升序列位置为k时矩阵中位置是(k/n,k%n)
        int m = matrix.length;
        int n = matrix[0].length;
        int total = m * n;
        int left = 0;
        int right = total - 1;
        while(left <= right){
            int mid = (left + right)>>1;
            int midValue = matrix[mid / n][mid % n];
            if(midValue == target){
                return true;
            }else if(midValue < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }
}
