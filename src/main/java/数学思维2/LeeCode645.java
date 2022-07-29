package 数学思维2;


/**
 * 645. 错误的集合
 * LeeCode 645
 * 难度 ： 简单
 */
public class LeeCode645 {

    public int[] findErrorNums(int[] nums) {
        int[] resule = new int[2];
        int[] temp = new int[nums.length+1];
        for(int num : nums) {
            temp[num]++;
        }

        for(int i = 1; i < temp.length; i++){
            if(temp[i] == 1)
                continue;
            if(temp[i] == 2)
                resule[0] = i;
            else
                resule[1] = i;
        }
        return resule;
    }
}
