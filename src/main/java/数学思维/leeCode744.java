package 数学思维;


import java.util.Arrays;

/**
 * 744. 寻找比目标字母大的最小字母
 * LeeCode 744
 * 难度 ： 简单
 */
public class leeCode744 {


    public char nextGreatestLetter(char[] letters, char target) {
        for (char letter : letters) {
            if (letter > target) return letter;
        }
        return letters[0];
    }
}
