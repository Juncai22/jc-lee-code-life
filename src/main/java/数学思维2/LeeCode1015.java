package 数学思维2;


/**
 * 1015. 可被 K 整除的最小整数
 * LeeCode 1015
 * 难度 ： 中等
 */
public class LeeCode1015 {

    public static void main(String[] args) {
        int x = 3;
        smallestRepunitDivByK(3);
    }

    public static int smallestRepunitDivByK(int K) {
        if ((K & 1) == 0 || K % 5 == 0) return -1;
        int x = 1;
        int cnt = 1;
//        X_i+1 = X_i*10 +1
//        X_i+1%K = (X_i*10 +1)%k = ((X_i*10)%k +1%K)%K
        while (x % K != 0) {
            cnt++;
            x = (x * 10) % K + 1;
        }
        return cnt;
    }
}
