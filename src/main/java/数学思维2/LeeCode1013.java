package 数学思维2;


/**
 * 1013. 将数组分成和相等的三个部分
 * LeeCode 1013
 * 难度 ： 简单
 */
public class LeeCode1013 {

    public static void main(String[] args) {
        canThreePartsEqualSum(new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4});
    }

    public static boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        // 数组A的和如果不能被3整除直接返回false
        if (sum % 3 != 0) {
            return false;
        }
        // 遍历数组累加，每累加到目标值cnt加1，表示又找到1段
        sum /= 3;
        int curSum = 0, cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            curSum += arr[i];
            if (curSum == sum) {
                cnt++;
                curSum = 0;
            }
        }
        // 最后判断是否找到了3段（注意如果目标值是0的话可以大于3段）
        return cnt >= 3;
    }
}
