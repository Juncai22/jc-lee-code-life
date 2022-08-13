package 数学思维2;

/**
 * 1304. 和为零的 N 个不同整数
 * LeeCode 1304
 * 难度 ： 简单
 */
public class LeeCode1304 {

    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int temp = 1;
        int x = n;
        if (n % 2 != 0){
            x = n - 1;
            ans[n - 1] = 0;
        }
        for (int i = 0; i < x; i++) {
            if (i % 2 == 0){
                temp *= -1;
                ans[i] = temp;
            }else{
                temp *= -1;
                ans[i] = temp;
                temp++;
            }
        }
        return ans;
    }
}
