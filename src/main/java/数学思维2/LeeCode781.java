package 数学思维2;


import java.util.HashSet;

/**
 * 781. 森林中的兔子
 * LeeCode 781
 * 难度 ： 中等
 */
public class LeeCode781 {

    public static void main(String[] args) {
        int[] answers = {0,0,1,1,1};
        int i = numRabbits(answers);
        System.out.println(i);
    }

    public static int numRabbits(int[] answers) {
        //因为限度只有1000，所以设置一个1000长度的数组，可以知道每个值为多少。
        int[] temp = new int[1000];
        for (int answer : answers) {
            temp[answer]++;
        }
        //进行一次for循环遍历，因为是至少，所以当某个数字的值大于了那个数字，便进行除法进行缩减.
        int ans = temp[0];
        for (int i = 1; i < temp.length; i++) {
            //当数字为0时，减去
            if (temp[i] == 0){
                continue;
            }
            //当数值小于等于数字，便直接++
            if (temp[i] <= i + 1) {
                ans += i + 1;
            }else{
                //大于数字，缩减之后在加
                ans += temp[i] / (i + 1) * (i + 1);
                if (!(temp[i] % (i + 1) == 0)){
                    ans += i + 1;
                }
            }
        }
        //返回ans
        return ans;
    }
}
