package 数学思维;


/**
 * 492. 构造矩形
 * LeeCode 492
 * 难度 ： 简单
 */
public class LeeCode492 {

    public int[] constructRectangle(int area) {
        int width = (int) Math.sqrt(area);
        while (area % width != 0) {
            width--;
        }
        return new int[]{area / width, width};
    }
}
