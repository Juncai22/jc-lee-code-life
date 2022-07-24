package 数学思维2;


/**
 * LCP 55. 采集果实
 * LeeCode 2399
 * 难度 ： 简单
 */
public class LeeCode2399 {

    public static void main(String[] args) {
        int[] time = {1,3,5,4};
        int[][] fruits = {{2,4},{3,3},{1,4},{0,3},{3,1},{3,2},{0,4},{2,3},{1,4}};
        int limeit = 2;
        int minimumTime = getMinimumTime(time, fruits, limeit);
        System.out.println(minimumTime);
    }

    public static int getMinimumTime(int[] time, int[][] fruits, int limit) {
        int timeans = 0;
        for (int[] fruit : fruits) {
            timeans += time[fruit[0]] * (fruit[1] % limit == 0 ? fruit[1] / limit : fruit[1] / limit + 1);
        }
        return timeans;
    }
}
