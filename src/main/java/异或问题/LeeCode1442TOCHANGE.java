package 异或问题;


/**
 * 1442. 形成两个异或相等数组的三元组数目
 * LeeCode 1442
 * 难度 ： 中等
 */
public class LeeCode1442TOCHANGE {


    public int countTriplets(int[] arr) {
        int len = arr.length;
        int ans = 0;

        for(int i = 0; i < len - 1; i ++){
            int sum = 0;
            for(int k = i; k < len ; k ++){
                sum ^= arr[k];
                if (sum == 0 && k > i) {
                    ans += (k - i);
                }
            }
        }
        return ans;
    }
}
