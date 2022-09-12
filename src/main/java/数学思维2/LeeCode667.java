package 数学思维2;


/**
 * 667. 优美的排列 II
 * LeeCode 667
 * 难度 ： 中等
 */
public class LeeCode667 {

    public static void main(String[] args) {
        constructArray(3, 1);
    }


    public static int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int temp = 1;
        int no = 0;
        for (int i = 0; i < ans.length; i++) {
            if (i % 2 == 1) {
                ans[i] = 1 + k - no;
                no++;
            } else {
                ans[i] = temp;
                temp++;
            }
            if (i > k) {
                ans[i] = i + 1;
            }
        }
        return ans;
    }
}
