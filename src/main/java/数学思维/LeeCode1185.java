package 数学思维;


/**
 * 1185. 一周中的第几天
 * LeeCode 1185
 * 难度 ： 简单
 */
public class LeeCode1185 {

    public static void main(String[] args) {
        String s = dayOfTheWeek(29, 2, 2016);
        System.out.println(s);
    }

    public static String dayOfTheWeek(int day, int month, int year) {
        String[] strings = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday","sunday"};
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int nowDays = 0;
        for (int i = 1971; i < year; i++) {
            if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                nowDays += 366;
            } else {
                nowDays += 365;
            }
        }

        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            for (int i = 1; i < month; i++) {
                if (i == 2) {
                    nowDays += 29;
                } else {
                    nowDays += days[i - 1];
                }
            }
        }else{
            for (int i = 1; i < month; i++) {
                    nowDays += days[i];
            }
        }
        nowDays += day;


        return strings[(nowDays + 3) % 7];
    }
}
