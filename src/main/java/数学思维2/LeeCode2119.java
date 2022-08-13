package 数学思维2;


/**
 * 2119. 反转两次的数字
 * LeeCode 2119
 * 难度 ： 简单
 */
public class LeeCode2119 {

    public boolean isSameAfterReversals(int num) {
        if (num == 0){
            return true;
        }
        if (num % 10 == 0){
            return false;
        }else{
            return true;
        }
    }
}
