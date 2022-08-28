package 数学思维2;


/**
 * 985. 查询后的偶数和
 * LeeCode 985
 * 难度 ： 中等
 */
public class LeeCode985 {

    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        //首先定义答案数组
        int[] ans = new int[queries.length];
        //然后实现偶数之和
        int m = 0;
        int temp = 0;
        //先进行第一次偶数和
        for (int num : nums)
            if (num % 2 == 0) temp += num;

            //进行加减之后在进行偶数和
        for (int[] query : queries) {
            if (nums[query[1]] % 2 == 0) temp -= nums[query[1]];
            nums[query[1]] += query[0];
            if (nums[query[1]] % 2 == 0) temp += nums[query[1]];
            ans[m] += temp;
            m++;
        }
        //返回结果
        return ans;
    }
}
