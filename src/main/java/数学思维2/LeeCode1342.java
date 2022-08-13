package 数学思维2;


/**
 * 1342. 将数字变成 0 的操作次数
 * LeeCode 1342
 * 难度 ： 简单
 */
public class LeeCode1342 {

    public int numberOfSteps(int num) {
        int x = 0;
        while (num != 0){
            if (num % 2 == 0){
                num /= 2;
            }else {
                num -= 1;
            }
            x++;
        }
        return x;
    }
}
