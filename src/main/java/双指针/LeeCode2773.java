package 双指针;


/**
 * 面试题 16.16. 部分排序
 * LeeCode 2773
 * 难度 ： 中等
 */
public class LeeCode2773 {

    public int[] subSort(int[] array) {
        int N = array.length, start = -1, end = -1;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        // 从前往后找目标末位，使得从该位到最后，数组保持递增
        for (int i = 0; i < N; i++) {
            if (array[i] >= max) max = array[i];
            else end = i;
        }

        // 数组恒递增，说明数组是有序的，直接返回
        if (end == -1) return new int[] {-1, -1};

        // 从后往前找目标首位，使得从该位到最前，数组保持递减
        for (int i = end; i >= 0; i--) {
            if (array[i] <= min) min = array[i];
            else start = i;
        }
        return new int[] {start, end};
    }
}
