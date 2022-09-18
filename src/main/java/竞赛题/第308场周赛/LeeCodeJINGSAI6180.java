package 竞赛题.第308场周赛;


/**
 * 6180. 最小偶倍数
 * LeeCode 6180
 * 难度 ： 简单
 */
public class LeeCodeJINGSAI6180 {


    public int smallestEvenMultiple(int n) {
        return (n % 2 == 0) ? n : n * 2;
    }
}
