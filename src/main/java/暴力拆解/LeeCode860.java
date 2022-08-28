package 暴力拆解;


/**
 * 860. 柠檬水找零
 * LeeCode 860
 * 难度 ： 简单
 */
public class LeeCode860 {

    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five >= 1) {
                    five--;
                    ten++;
                } else {
                    return false;
                }
            } else {
                if (ten >= 1 && five >= 1) {
                    ten--;
                    five--;
                } else if (ten == 0 && five >= 3) {
                    five -= 3;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
