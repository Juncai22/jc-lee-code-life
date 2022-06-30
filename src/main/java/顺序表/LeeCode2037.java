package 顺序表;

import javax.lang.model.type.ArrayType;
import java.util.Arrays;

/**
 * 2037. 使每位学生都有座位的最少移动次数
 * LeeCode 2037
 * 难度 ： 简单
 */
public class LeeCode2037 {
    public static void main(String[] args) {
        int[] seats = {4,1,5,9};
        int[] students = {1,3,2,6};
        int i = minMovesToSeat(seats, students);
        System.out.println(i);
    }



    //排序
    public static int minMovesToSeat(int[] seats, int[] students) {
        //现将需要排序的两个数组排序
        Arrays.sort(seats);
        Arrays.sort(students);

        //初始m，并在运算知乎进行返回
        int m = 0;
        for (int i = 0; i < seats.length; i++) {
            if (students[i] - seats[i] < 0){
                //如果小于零，那加*-1
                m += seats[i] - students[i];
                continue;
            }
            m += students[i] - seats[i];
        }

        return m;
    }
}
