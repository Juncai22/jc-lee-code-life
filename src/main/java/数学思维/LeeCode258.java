package 数学思维;


/**
 * 258. 各位相加
 * LeeCode 258
 * 难度 ： 简单
 */
public class LeeCode258 {


    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }

}



