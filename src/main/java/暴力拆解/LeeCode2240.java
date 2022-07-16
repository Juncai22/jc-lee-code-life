package 暴力拆解;


/**
 * 2240. 买钢笔和铅笔的方案数
 * LeeCode 2240
 * 难度 ： 中等
 */
public class LeeCode2240 {

    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        int pen = total / cost1;
        long totaNum = 0;
        for (int i = 0; i < pen + 1; i++) {
            totaNum += (total - (cost1 * i)) / cost2 + 1;
        }
        return totaNum;
    }
}
