package 暴力拆解;



/**
 * 1450. 在既定时间做作业的学生人数
 * LeeCode 1450
 * 难度 ： 简单
 */
public class LeeCode1450 {


    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int ans = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && queryTime <= endTime[i]){
                ans++;
            }
        }
        return ans;
    }
}
