package 数学思维2;


/**
 * 2310. 两个数组的交集 II
 * LeeCode 2310
 * 难度 ： 中等
 */
public class LeeCode2310 {

    public static void main(String[] args) {
        int i = minimumNumbers(10, 8);
        System.out.println(i);
    }

    public static int minimumNumbers(int num, int k) {
        if (num == 0) return 0; // num为0的情况单独讨论
        // num >= k的情况:至少需要一个
        for (int i = 1; i <= num; i++) {
            int t =i * k;
            if (t % 10 == num % 10 && t > 0 && t < num){
                return i;
            }
        }
        return -1;
    }
}
