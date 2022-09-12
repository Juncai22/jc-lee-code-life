package 数学思维2;


/**
 * 1394. 找出数组中的幸运数
 * LeeCode 1394
 * 难度 ： 简单
 */
public class LeeCode1394 {


    public int findLucky(int[] arr) {
        int[] temp = new int[501];
        for (int i : arr) {
            temp[i]++;
        }
        for (int i = 1; i < temp.length; i++) {
            if (i == temp[i]) {
                return i;
            }
        }
        return -1;
    }
}
