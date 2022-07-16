package 双指针;


/**
 * 167. 两数之和 II - 输入有序数组
 * LeeCode 167
 * 难度 ： 中等
 */
public class LeeCode167 {

    public static void main(String[] args) {
        int[] numbers = {-1, 0};
        int target = -1;
        int[] ints = twoSum(numbers, target);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public static int[] twoSum(int[] numbers, int target) {
        //双指针
        int end = 0;
        int begin = 0;
        //首先先排除比target大的数
        for (int i = numbers.length - 1; i > 0; i--) {
            if (i + 1 < numbers.length && numbers[i] <= target && numbers[i + 1] >= target) {
                end = i;
                break;
            } else if (i + 1 == numbers.length) {
                end = i;
            }
        }
        //使用while循环，找到所需的两个数
        while (true) {
            if (numbers[begin] + numbers[end] > target) {
                end--;
            } else if (numbers[begin] + numbers[end] < target) {
                begin++;
            } else {
                break;
            }
        }
        //如果begin大于end，则相反
        if (begin > end) {
            int temp = begin;
            begin = end;
            end = temp;
        }
        //返回值
        return new int[]{begin + 1, end + 1};
    }
}
