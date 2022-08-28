package 暴力拆解;


import java.util.Arrays;

/**
 * 2126. 摧毁小行星
 * LeeCode 2126
 * 难度 ： 中等
 */
public class LeeCode2126 {

    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);

        long massd = mass;
        for (int asteroid : asteroids) {
            if (massd < asteroid) return false;
            massd += asteroid;
        }
        return true;
    }
}
