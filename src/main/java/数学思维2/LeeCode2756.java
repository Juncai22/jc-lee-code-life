package 数学思维2;


/**
 * 面试题 16.15. 珠玑妙算
 * LeeCode 2756
 * 难度 ： 简单
 */
public class LeeCode2756 {


    public int[] masterMind(String solution, String guess) {
        int[] ans = {0, 0};
        int[] temp0 = new int[26];
        int[] temp1 = new int[26];

        for (int i = 0; i < solution.length(); i++) {
            if (solution.charAt(i) == guess.charAt(i)) ans[0]++;
            temp0[solution.charAt(i) - 'A']++;
            temp1[guess.charAt(i) - 'A']++;
        }
        for (int i = 0; i < temp1.length; i++) {
            ans[1] += Math.min(temp0[i], temp1[i]);
        }
        ans[1] -= ans[0];
        return ans;
    }
}
