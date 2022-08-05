package 暴力拆解;


/**
 * 1007. 行相等的最少多米诺旋转
 * LeeCode 1007
 * 难度 ： 中等
 */
public class LeeCode1007 {

    public static void main(String[] args) {
        int[] tops = {2,1,2,4,2,2};
        int[] bottoms = {5,2,6,2,3,2};

        int i = minDominoRotations(tops, bottoms);
        System.out.println(i);

    }

    public static int minDominoRotations(int[] tops, int[] bottoms) {
        //首先运用临时数组将答案全部保存进入单个数组
        int[] temp1 = new int[7];
        int[] temp2 = new int[7];
        int n = 0;
        //将数据保存到各位数组
        for (int top : tops) {
            temp1[top]++;
        }
        for (int bottom : bottoms) {
            temp2[bottom]++;
        }
        //循环遍历看是否满足有一个数大于总数的百分之五十
        for (int i = 0; i < 7; i++) {
            if (temp1[i] + temp2[i] >= tops.length) {
                int temp = tops.length - Math.max(temp1[i], temp2[i]);
                int x = temp1[i] > temp2[i] ? 1 : 2;
                //检查是否每个数字都是交叉相反的
                for (int m = 0; m < tops.length; m++) {
                    if (x == 1){
                        if (tops[m] != i && bottoms[m] == i){
                            n++;
                        }//直接不是，返回-1
                        else if(tops[m] != i && bottoms[m] != i){
                            return -1;
                        }//最终结果是否为n大于最小满足的数，满足就返回temp
                        if (temp <= n && m == tops.length - 1){
                            return temp;
                        }
                    }else{
                        if (bottoms[m] != i && tops[m] == i){
                            n++;
                        }else if(bottoms[m] != i && tops[m] != i){
                            return -1;
                        }
                        if (temp <= n && m == tops.length - 1){
                            return temp;
                        }
                    }
                }
            }
        }
        //全遍历完了，没得到结果返回-1
        return -1;

    }
}
