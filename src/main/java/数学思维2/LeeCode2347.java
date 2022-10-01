package 数学思维2;


/**
 * 2347. 最好的扑克手牌
 * LeeCode 2347
 * 难度 ： 简单
 */
public class LeeCode2347 {


    public String bestHand(int[] ranks, char[] suits) {
        if (suits[0] == suits[1] && suits[0] == suits[2] && suits[0] == suits[3] && suits[0] == suits[4]) {
            return "Flush";
        }
        String ans = "High Card";
        int count[] = new int[15];
        for (int i = 0; i < 5; i++) {
            count[ranks[i]]++;
            if (count[ranks[i]] == 3) {
                return "Three of a Kind";
            } else if (count[ranks[i]] == 2) {
                ans = "Pair";
            }
        }
        return ans;
    }
}
