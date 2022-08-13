package 暴力拆解;


/**
 * 1952. 三除数
 * LeeCode 1952
 * 难度 ： 简单
 */
public class LeeCode1952 {

    public boolean isThree(int n) {

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (n % (i + 1) == 0){
                ans++;
            }
        }
        return ans == 3;
    }
}
