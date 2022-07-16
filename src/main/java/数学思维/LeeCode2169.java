package 数学思维;


/**
 * 2169. 得到 0 的操作数
 * LeeCode 2169
 * 难度 ： 简单
 */
public class LeeCode2169 {

    public int countOperations(int num1, int num2) {
        int ans = 0;
        while (num1 > 0 && num2 > 0){
            if (num1 >= num2) num1 -= num2;
            else num2 -= num1;
            ans++;
        }
        return ans;
    }
}
