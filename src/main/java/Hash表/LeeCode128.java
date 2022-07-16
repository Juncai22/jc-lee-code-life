package Hash表;


import java.util.HashSet;

/**
 * 128. 最长连续序列
 * LeeCode 128
 * 难度 ： 中等
 */
public class LeeCode128 {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        HashSet<Integer> intem = new HashSet<>();
        //先将所有放入Hash里面
        for (int num : nums) {
            intem.add(num);
        }

        int ansnum = 1;
        //将从最小执行，所以先判断是否为最小，在进行递增，递增到最大，便进行返回。
        for (int num : nums) {
            int tempNum = num;
            if (!intem.contains(num - 1)){
                while (intem.contains(tempNum + 1)){
                    tempNum++;
                    ansnum = Math.max(tempNum - num + 1,ansnum);
                }
            }
        }
        return ansnum;
    }
}
