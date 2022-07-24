package 数学思维2;


/**
 * LCP 01. 猜数字
 * LeeCode 2345
 * 难度 ： 简单
 */
public class LeeCode2345 {


    public int game(int[] guess, int[] answer) {
        //定义两个数字，一个是指针，一个是答案
        int i = 0;
        int ans = 0;
        //让指针往后传递，相同答案++，不相同答案--。
        while (i < guess.length){
            if (guess[i] == answer[i]){
                ans++;
                i++;
            }else{
                i++;
            }
        }
        //返回答案
        return ans;
    }

}
