package 数学思维2;




/**
 * 481. 神奇字符串
 * LeeCode 481
 * 难度 ： 中等
 */

public class LeeCode481TOCHANGE {


    public int magicalString(int n) {
// 初始状态
        StringBuilder sb = new StringBuilder("122");
        int a = 2;
        int b = 2;
        // 开始遍历
        for(;a<n;){
            int temp = sb.charAt(a)-'0'==1?2:1; // 如果当前a指向为2，那么就准备添加1，反之亦同
            for(int i=0; i<sb.charAt(b)-'0';i++)sb.append(temp); // 增加当前b次
            a = sb.length() - 1; // a永远指向末尾
            b++; //b挨个递增
        }
        // 数个数，返回值
        int res = 0;
        for(int i=0; i<n;i++)
            if(sb.charAt(i)=='1')res++;
        return res;
    }
}
