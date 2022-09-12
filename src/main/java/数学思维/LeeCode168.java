package 数学思维;


/**
 * 168. Excel表列名称
 * LeeCode 168
 * 难度 ： 简单
 */
public class LeeCode168 {

    public static void main(String[] args) {
        convertToTitle(52);
    }

    public static String convertToTitle(int columnNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        while (columnNumber > 0) {
            if (columnNumber <= 26) {
                stringBuilder.append((char) (columnNumber + 64));
                break;
            }
            int temp = columnNumber % 26;
            if (temp == 0) {
                stringBuilder.append('z');
                columnNumber--;
            } else stringBuilder.append((char) (temp + 64));
            columnNumber -= temp;
            columnNumber /= 26;
        }

        return stringBuilder.reverse().toString();
    }
}
