package 数学思维;


/**
 * 2068. 检查两个字符串是否几乎相等
 * LeeCode 2068
 * 难度 ： 简单
 */
public class LeeCode2068 {

    public static void main(String[] args) {
        String word1 = "zzzyyy";
        String word2 = "iiiiii";
        boolean b = checkAlmostEquivalent(word1, word2);
        System.out.println(b);
    }

    public static boolean checkAlmostEquivalent(String word1, String word2) {
        //将字符串转化为字符集合
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        //模拟Hash表，进行加减
        int[] arr = new int[26];

        //循环查看加减次数
        for (char c : chars1) {
            arr[c - 'a']++;
        }
        for (char c : chars2) {
            arr[c - 'a']--;
        }
        //超过3次便返回false
        for (int i : arr) {
            if (i > 3 || i < -3){
                return false;
            }
        }

        return true;
    }
}
