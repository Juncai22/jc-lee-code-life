package 差分数组;


/**
 * 1109. 航班预订统计
 * LeeCode 1109
 * 难度 ： 中等
 */
public class LeeCode1109 {

    public static void main(String[] args) {
        int[][] bookings = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int n = 5;
        corpFlightBookings(bookings, n);
    }

    public static int[] corpFlightBookings2(int[][] bookings, int n) {
        int[] ans = new int[n];
        for (int[] booking : bookings) {
            for (int j = booking[0] - 1; j < booking[1]; j++) {
                ans[j] += booking[2];
            }
        }
        return ans;
    }

    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        for (int[] booking : bookings) {
            nums[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                nums[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
