package 暴力拆解;


/**
 * 1694. 重新格式化电话号码
 * LeeCode 1694
 * 难度 ： 简单
 */
public class LeeCode1694 {

    public static void main(String[] args) {
        reformatNumber("--17-5 229 35-39475 ");
    }

    public static String reformatNumber(String number) {
        //进行可变数组的变化
        StringBuilder stringBuilder = new StringBuilder(number);
        StringBuilder ans = new StringBuilder();
        int mt = 0;
        //进行原地的删除与检查
        while (mt < stringBuilder.length()){
            if (stringBuilder.charAt(mt) == ' ' || stringBuilder.charAt(mt) == '-') stringBuilder.deleteCharAt(mt);
            else mt++;
        }
        //看一下是否是2,3,4其中一个
        int m = stringBuilder.length() % 3;
        //为1便用另外一种，其他便用另外一种
        if (m == 1){
            for (int i = 0; i < stringBuilder.length(); i++) {
                if (i % 3 == 0 && i != 0&& i < stringBuilder.length() - 4) ans.append('-');
                if ((i == stringBuilder.length() - 2 || i == stringBuilder.length() - 4) && i != 0) ans.append('-');
                ans.append(stringBuilder.charAt(i));
            }
        }

        else {
            for (int i = 0; i < stringBuilder.length(); i++) {
                if (i % 3 == 0 && i != 0) ans.append('-');
                ans.append(stringBuilder.charAt(i));
            }
        }
        //直接放回
        return String.valueOf(ans);
    }
}
