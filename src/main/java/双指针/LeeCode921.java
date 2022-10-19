package 双指针;


/**
 * 921. 使括号有效的最少添加
 * LeeCode 921
 * 难度 ： 中等
 */
public class LeeCode921 {

    public static void main(String[] args) {
        String s = "))))(";
        minAddToMakeValid(s);
    }

    public static int minAddToMakeValid(String s) {
        //定义双指针,右边的话是直接想加的，因为不可能在被抵消
        int lcount = 0, rcount = 0;
        for (int i = 0; i < s.length(); i++) {
            //如果为（则l++；
            if (s.charAt(i) == '(') lcount++;
            //如果为）则先要把l抵消掉，在r++；
            else {
                if (lcount > 0) lcount--;
                else rcount++;
            }
        }
        return lcount + rcount;
    }
}
