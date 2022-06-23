package 双指针;


/**
 * 941. 有效的山脉数组
 * LeeCode 941
 * 难度 ： 简单
 */
public class LeeCode941 {

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        boolean b = validMountainArray(arr);
        System.out.println(b);
    }


    //双指针
    public static boolean validMountainArray(int[] arr) {
        int N = arr.length;
        int i = 0;

        // 递增扫描
        while (i + 1 < N && arr[i] < arr[i + 1]) {
            i++;
        }

        // 最高点不能是数组的第一个位置或最后一个位置
        if (i == 0 || i == N - 1) {
            return false;
        }

        // 递减扫描
        while (i + 1 < N && arr[i] > arr[i + 1]) {
            i++;
        }

        return i == N - 1;
    }

    //暴力拆解
    public static boolean validMountainArray2(int[] arr) {
        //制造一个提前变量，来控制是否正确
        int temp = arr[0];
        //如果长度小于3即为错误
        if (arr.length <= 2) {
            return false;
        }
        //如果第一个大于第二也错误
        if (arr[0] > arr[1]) {
            return false;
        }
        //中间值
        int c = 0;
        for (int i = 1; i < arr.length; i++) {
            //比较是否要相等的，如果有就返回错误
            if (temp == arr[i]) {
                return false;
            }
            //使临时变量向后进位
            if (arr[i] > temp) {
                temp = arr[i];
            } else {
                //得到中间值，并使中间值继续遍历
                c = i;
                break;
            }
            //如果第一份已经到达了最后，则返回错误
            if (i == arr.length - 1) {
                return false;
            }
        }
        //从c开始遍历
        for (int i = c; i < arr.length; i++) {
            if (arr[i] >= temp) {
                return false;
            } else {
                temp = arr[i];
            }
            if (i == arr.length - 1) {
                return true;
            }
        }
        return true;
    }
}
