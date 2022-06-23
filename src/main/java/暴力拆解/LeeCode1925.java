package 暴力拆解;


/**
 * 1925. 统计平方和三元组的数目
 * LeeCode 1925
 * 难度 ： 简单
 */
public class LeeCode1925 {

    public int countTriples(int n) {
        //超强3层for循环
        int count = 0;
        for (int i = 1; i <= n - 2; i++) {
            for (int j = i + 1; j <= n - 1; j++) {
                for (int k = j + 1; k <= n; k++) {
                    if (i * i + j * j == k * k)
                        count++;
                }
            }
        }
        return count * 2;
    }
}
