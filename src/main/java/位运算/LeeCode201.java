package 位运算;


/**
 * 201. 数字范围按位与
 * LeeCode 201
 * 难度 ： 中等
 */
public class LeeCode201 {


        public int rangeBitwiseAnd(int m, int n) {
            while(n > m) {
                n &= n-1;
            }
            return n;
    }
}
