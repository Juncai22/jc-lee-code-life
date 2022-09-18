package 数学思维2;


import java.util.Arrays;

/**
 * 1046. 最后一块石头的重量
 * LeeCode 1046
 * 难度 ： 简单
 */
public class LeeCode1046TOCHANGE {


    public int lastStoneWeight(int[] stones) {
        if (stones.length == 2) {
            return Math.abs(stones[0] - stones[1]);
        }
        if (stones.length == 1) {
            return stones[0];
        }
        Arrays.sort(stones);
        if (stones[stones.length - 3] == 0) {
            return stones[stones.length - 1] - stones[stones.length - 2];
        }
        stones[stones.length - 1] = stones[stones.length - 1] - stones[stones.length - 2];
        stones[stones.length - 2] = 0;
        return lastStoneWeight(stones);
    }
}
