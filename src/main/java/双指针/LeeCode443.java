package 双指针;


/**
 * 443. 压缩字符串
 * LeeCode 443
 * 难度 ： 中等
 */
public class LeeCode443 {

    //我制作的算法,主要是数个数并相加起来
    public static int compress(char[] chars) {
        //这是指的数字的数量
        int temp = 1;
        //根据这个来改变
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(chars[0]);
        //for循环，根据不同的循环走出不同的结果
        for (int i = 1; i < chars.length; i++) {

            if (chars[i] == chars[i - 1]) {
                temp++;
            } else if (chars[i] != chars[i - 1] && temp > 1) {
                stringBuilder.append(temp);
                temp = 1;
                stringBuilder.append(chars[i]);
            } else {
                stringBuilder.append(chars[i]);
            }
            if (i == chars.length - 1 && chars[i] == chars[i - 1]) {
                stringBuilder.append(temp);
            }
        }
        return stringBuilder.length();
    }

    //第二种方法，双指针运算
    public int compress2(char[] chars) {
        int n = chars.length;
        int write = 0, left = 0;
        for (int read = 0; read < n; read++) {
            if (read == n - 1 || chars[read] != chars[read + 1]) {
                chars[write++] = chars[read];
                int num = read - left + 1;
                if (num > 1) {
                    int anchor = write;
                    while (num > 0) {
                        chars[write++] = (char) (num % 10 + '0');
                        num /= 10;
                    }
                    reverse(chars, anchor, write - 1);
                }
                left = read + 1;
            }
        }
        return write;
    }

    public void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
