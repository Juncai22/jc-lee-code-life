package 数学思维2;


/**
 * 1904. 你完成的完整对局数
 * LeeCode 1904
 * 难度 ： 中等
 */
public class LeeCode1904 {


    public int numberOfRounds(String startTime, String finishTime) {
        int s_hour = Integer.parseInt(startTime.substring(0, 2));
        int s_minute = Integer.parseInt(startTime.substring(3, 5));
        int f_hour = Integer.parseInt(finishTime.substring(0, 2));
        int f_minute = Integer.parseInt(finishTime.substring(3, 5));
        int res = f_minute - s_minute + 60 * (f_hour - s_hour);
        if (res < 0) res += 24 * 60;
        if (s_minute == 0) {

        } else if (s_minute <= 15) {
            res -= 15 - s_minute;
        } else if (s_minute <= 30) {
            res -= 30 - s_minute;
        } else if (s_minute <= 45) {
            res -= 45 - s_minute;
        } else if (s_minute <= 60) {
            res -= 60 - s_minute;
        }
        return res >= 0 ? res / 15 : 0;
    }
}
