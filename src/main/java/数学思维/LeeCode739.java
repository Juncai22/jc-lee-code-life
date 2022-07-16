package 数学思维;


import java.util.ArrayList;
import java.util.List;

/**
 * 739. 每日温度
 * LeeCode 739
 * 难度 ： 中等
 */
public class LeeCode739 {

    //普通的双重for循环
    public int[] dailyTemperatures(int[] temperatures) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i; j < temperatures.length; j++) {
                if (temperatures[i] < temperatures[j]) {
                    ans.add(j - i);
                    break;
                } else if (temperatures[i] >= temperatures[j] && j == temperatures.length - 1) {
                    ans.add(0);
                }
            }
        }
        int[] ans2 = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            ans2[i] = ans.get(i);
        }

        return ans2;

    }

    /**
     * 根据题意，从最后一天推到第一天，这样会简单很多。因为最后一天显然不会再有升高的可能，结果直接为0。
     * 再看倒数第二天的温度，如果比倒数第一天低，那么答案显然为1，如果比倒数第一天高，又因为倒数第一天
     * 对应的结果为0，即表示之后不会再升高，所以倒数第二天的结果也应该为0。
     * 自此我们容易观察出规律，要求出第i天对应的结果，只需要知道第i+1天对应的结果就可以：
     * - 若T[i] < T[i+1]，那么res[i]=1；
     * - 若T[i] > T[i+1]
     *   - res[i+1]=0，那么res[i]=0;
     *   - res[i+1]!=0，那就比较T[i]和T[i+1+res[i+1]]（即将第i天的温度与比第i+1天大的那天的温度进行比较）
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    //for循环的另外一种办法
    public int[] dailyTemperatures2(int[] temperatures) {
        int[] res = new int[temperatures.length];
        res[temperatures.length - 1] = 0;
        for (int i = temperatures.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < temperatures.length; j += res[j]) {
                if (temperatures[i] < temperatures[j]) {
                    res[i] = j - i;
                    break;
                } else if (res[j] == 0) {
                    res[i] = 0;
                    break;
                }
            }
        }
        return res;
    }

}
