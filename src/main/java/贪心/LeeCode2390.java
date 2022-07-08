package 贪心;


/**
 * LCS 01. 下载插件
 * LeeCode 2390
 * 难度 ： 简单
 */
public class LeeCode2390 {

    public int leastMinutes(int n) {

        int tg = 1;
        int time = 0;
        //无线扩容，直到一秒下完
        while (tg < n) {
            time++;
            tg *= 2;
        }
        return ++time;
    }
}
