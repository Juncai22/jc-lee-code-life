package 数学思维;



/**
 * 848. 1 比特与 2 比特字符
 * LeeCode 848
 * 难度 ： 中等
 */
public class LeeCode848 {

    public static void main(String[] args) {
        int[] asd = {505870226, 437526072, 266740649, 224336793, 532917782, 311122363, 567754492, 595798950, 81520022, 684110326, 137742843, 275267355, 856903962, 148291585, 919054234, 467541837, 622939912, 116899933, 983296461, 536563513};
        String abc = shiftingLetters("mkgfzkkuxownxvfvxasy", asd);
        System.out.println(abc);

    }

    public static String shiftingLetters(String s, int[] shifts) {

        //设置一个临时数组，储存我们的数独
        char[] rePair = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        //将改为字符集
        char[] chars = s.toCharArray();
        //字符集改为数字机
        int[] reTool = new int[s.length()];

        for (int i = 0; i < chars.length; i++) {
            reTool[i] = chars[i];
        }
        StringBuilder mq = new StringBuilder();
        for (int i = shifts.length - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                //以免超过int
                reTool[j] += shifts[i] % 26;
            }
            if ((reTool[i] - 97) % 26 < 0) {
                //可能会有负数，所以两种分类
                mq.append(rePair[(reTool[i] - 97) % 26]);
            } else {
                mq.append(rePair[(reTool[i] - 97) % 26]);
            }
        }
        return new StringBuffer(mq.toString()).reverse().toString();
    }
}
