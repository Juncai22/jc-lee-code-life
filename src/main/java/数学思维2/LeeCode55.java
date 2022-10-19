package 数学思维2;


/**
 * 55. 跳跃游戏
 * LeeCode 55
 * 难度 ： 中等
 */
public class LeeCode55 {

    public static void main(String[] args) {
        canJump(new int[]{3,0,2,0,1,1,4});
    }

    public static boolean canJump(int[] nums) {
        int n=1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]>=n)
            {
                n=1;
            }
            else
            {
                n++;
            }
            if(i==0&&n>1)
            {
                return false;
            }
        }
        return true;
    }
}
