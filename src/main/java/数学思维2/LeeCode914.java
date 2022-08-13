package 数学思维2;


/**
 * 914. 卡牌分组
 * LeeCode 914
 * 难度 ： 简单
 */
public class LeeCode914 {

    public static void main(String[] args) {
        hasGroupsSizeX(new int[]{1,2,3,4,4,3,2,1});
    }

    public static boolean hasGroupsSizeX(int[] deck) {
        // 计数
        int[] counter = new int[10000];
        for (int num: deck) {
            counter[num]++;
        }
        // 求gcd
        int x = 0;
        for(int cnt: counter) {
            if (cnt > 0) {
                x = gcd(x, cnt);
                if (x == 1) {
                    return false;
                }
            }
        }
        return x >= 2;
    }

    // 辗转相除法
    private static int gcd (int a, int b) {
        return b == 0? a: gcd(b, a % b);
    }
}
