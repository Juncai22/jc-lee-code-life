package 数学思维;


/**
 * 1837. K 进制表示下的各位数字总和
 * LeeCode 1837
 * 难度 ： 简单
 */
public class LeeCode1837 {


    public int sumBase(int n, int k) {
        //将10进制转化为其他进制的方法
        int ans = 0;
        while (n > 0) {
            int t = n % k;
            n /= k;
            ans += t;
        }
        return ans;
    }
}
