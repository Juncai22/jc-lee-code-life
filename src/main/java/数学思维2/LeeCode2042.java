package 数学思维2;


/**
 * 2042. 检查句子中的数字是否递增
 * LeeCode 2042
 * 难度 ： 简单
 */
public class LeeCode2042 {

    public boolean areNumbersAscending(String s) {
        String[] strs = s.split(" ");
        int num = -1;
        for(String str : strs){
            // 先判断当前str是不是数字
            if(str.charAt(0) >= '0'&& str.charAt(0) <= '9'){
                // 数字前提下 去判断前后大小
                if(Integer.parseInt(str) > num)
                    num = Integer.parseInt(str);
                else
                    return false;
            }
        }
        return true;
    }
}
