package 暴力拆解;


import java.util.Arrays;
import java.util.Collections;

/**
 * 2165. 重排数字的最小值
 * LeeCode 2165
 * 难度 ： 中等
 */
public class LeeCode2165 {

    public static void main(String[] args) {
        smallestNumber(310);
    }

    public static long smallestNumber(long num) {
        if(num == 0) return 0;
        boolean f = num > 0;
        if(!f) num *= -1;
        char[] chs = (num + "").toCharArray();
        Arrays.sort(chs);
        if(f){
            int i=0;
            while(chs[i] == '0') i++;
            char c = chs[i];
            chs[i] = chs[0];
            chs[0] = c;
        }
        num = 0;
        for(int i=0; i<chs.length; i++){
            int j = f ? i : chs.length - i - 1;
            num = num*10 + (chs[j] - '0');
        }
        return f ? num : num*-1;
    }
}
