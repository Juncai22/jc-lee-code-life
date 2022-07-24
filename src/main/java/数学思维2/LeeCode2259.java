package 数学思维2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2259. 移除指定数字得到的最大结果
 * LeeCode 2259
 * 难度 ： 简单
 */
public class LeeCode2259 {

    public static void main(String[] args) {
        String s = "123";
        char digit = '3';
        String s1 = removeDigit(s, digit);
        System.out.println(s1);
    }

    public static String removeDigit(String number, char digit) {
        int len = number.length();
        int index = 0;
        for(int i = 0;i < len;i++){
            if(number.charAt(i) == digit){
                //如果当前digit小于它之后的数,则直接删除当前digit
                if(i + 1 < len && number.charAt(i + 1) > digit){
                    index = i;
                    break;
                }
                //记录当前digit的位置
                index = i;
            }
        }
        //如果digit的当前位置为字符串最后一个,则直接删除最后一个,反之则删除它再两边拼接
        if(index == len -1){
            return number.substring(0,index);
        }else{
            return number.substring(0,index) + number.substring(index + 1);
        }
    }
}
