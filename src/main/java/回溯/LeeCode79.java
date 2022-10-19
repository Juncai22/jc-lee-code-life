package 回溯;


import java.util.Objects;

/**
 * 79. 单词搜索
 * LeeCode 79
 * 难度 ： 中等
 */
public class LeeCode79 {

    public static void main(String[] args) {
        char[][] board = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
//        char[][] board = {{'A','A'}};
        exist(board, "AAB");
    }

    //小小回溯可笑，可笑
    public static boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == chars[0]) {
                    if (boardToCheck(board, chars, i, j, 0)) return true;
                }
            }
        }
        return false;
    }

    private static boolean boardToCheck(char[][] board, char[] chars, int i, int j, int m) {
        if (m == chars.length - 1 && board[i][j] == chars[m]) return true;

        if (board[i][j] == chars[m++]) {
            //设置一个clone的东西
            char[][] clone = clones(board);
            clone[i][j] = '&';
            //进行递归回缩，并收集得到答案
            if (i + 1 < board.length && boardToCheck(clone, chars, i + 1, j, m)) return true;
            if (i - 1 >= 0 && boardToCheck(clone, chars, i - 1, j, m)) return true;
            if (j + 1 < board[0].length && boardToCheck(clone, chars, i, j + 1, m)) return true;
            if (j - 1 >= 0 && boardToCheck(clone, chars, i, j - 1, m)) return true;
        }
        //如果一直没有返回，则代表没有true
        return false;
    }

    private static char[][] clones(char[][] board) {
        char[][] clone = new char[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                clone[i][j] = board[i][j];
            }
        }
        return clone;
    }
}
