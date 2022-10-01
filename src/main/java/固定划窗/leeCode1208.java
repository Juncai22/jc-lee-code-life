package 固定划窗;


/**
 * 1208. 尽可能使字符串相等
 * LeeCode 1208
 * 难度 ： 中等
 */
public class leeCode1208 {

    public static void main(String[] args) {
        equalSubstring("abcd",
                "bcdf",
                3);
    }

    public static int equalSubstring(String s, String t, int maxCost) {
        //首先定义一个数组，看每一个的数字差距
        int[] temp = new int[s.length()];
        //for循环进行循环得到差距
        for (int i = 0; i < s.length(); i++) {
            temp[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        //定义左边界，有边界，还有最终答案
        int ans = 0;
        int l = 0, r = 0;
        //进行滑动，看相连的是否有结果
        while (r < s.length()) {
            maxCost -= temp[r++];
            if (maxCost < 0) maxCost += temp[l++];
            //结果由有边界减掉左边界得到
            ans = Math.max(r - l, ans);
        }
        //返回
        return ans;
    }

}
