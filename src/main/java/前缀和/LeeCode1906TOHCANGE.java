package 前缀和;


import java.util.Arrays;
import java.util.TreeSet;

/**
 * 1906. 查询差绝对值的最小值
 * LeeCode 1906
 * 难度 ： 中等
 */
public class LeeCode1906TOHCANGE {

    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        TreeSet<Integer> subSet = new TreeSet<Integer>();
        for(int i=606;i<613;i++){
            if(i%2==0){
                set.add(i);
            }
        }
        subSet = (TreeSet)set.subSet(608,true,611,true);
        set.add(609);
        System.out.println(set+" "+subSet);
    }

    public static int[] minDifference(int[] nums, int[][] queries) {
//        int[] ans = new int[queries.length];
//        int ani = 0;
//        for (int[] query : queries) {
//            int[] temp = new int[query[1] - query[0] + 1];
//            int m = 0;
//            for (int i = query[0]; i <= query[1]; i++) {
//                temp[m++] = nums[i];
//            }
//            Arrays.sort(temp);
//            int[] quickT = new int[temp.length - 1];
//            for (int i = 0; i < quickT.length; i++) {
//                quickT[i] = Math.abs(temp[i + 1] - temp[i]);
//            }
//            Arrays.sort(quickT);
//            int min = 0;
//            while (quickT[min] == 0 && min + 1 < quickT.length){
//                min++;
//            }
//            ans[ani++] = quickT[min] == 0 ? -1 : quickT[min];
//
//        }
//        return ans;


        int n = nums.length;
        int[][] pre = new int[n + 1][101];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 101; j++)
                pre[i + 1][j] = pre[i][j]; // 将前面的前缀信息也记录起来
            pre[i + 1][nums[i]]++;
        }

        int size = queries.length;
        int[] ans = new int[size];

        for (int i = 0; i < size; i++) {
            int left = queries[i][0], right = queries[i][1];
            int minValue = Integer.MAX_VALUE, last = -1;

            for (int j = 1; j <= 100; j++) {
                if (pre[left][j] < pre[right + 1][j]) { // 证明存在
                    if (last != -1)
                        minValue = Math.min(minValue, j - last);
                    last = j;
                }
            }
            if (minValue == Integer.MAX_VALUE)
                minValue = -1;
            ans[i] = minValue;
        }

        return ans;
    }
}
