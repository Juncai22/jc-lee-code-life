package 数学思维;


/**
 * 717. 1 比特与 2 比特字符
 * LeeCode 717
 * 难度 ： 简单
 */
public class LeeCode717 {

    public static void main(String[] args) {
        int[] bits = {1,1,0};
        boolean oneBitCharacter = isOneBitCharacter(bits);
        System.out.println(oneBitCharacter);
    }

    public static boolean isOneBitCharacter(int[] bits) {
        int start = 0 ;
        //将while循环直到结果
        while(start<bits.length-1){
            if(bits[start] == 0){
                //如果为0直接当作1bit
                start++;
            }else{
                //如果为1直接当作2bit
                start+=2;
            }
        }
        //查看结果是否与长度相同
        return start == bits.length-1;
    }
}
