package DFS深度优先搜索;


/**
 * 130. 被围绕的区域
 * LeeCode 130
 * 难度 ： 中等
 */

public class LeeCode130 {

    public static void main(String[] args) {
        char[][] board = {{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}};
        solve(board);
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }


    public static void solve(char[][] board) {
        //先算清在边界的，与O相连的O的个数。
        for (int i = 0; i < board[0].length; i++) {
            invild(board, i, 0);
            invild(board, i, board[0].length - 1);
        }
        for (int i = 0; i < board[0].length; i++) {
            invild(board, 0, i);
            invild(board, board.length - 1, i);
        }
        //将为转换的O转换为X,将转换为-的O，转换回来
        for (int i = 0; i < board.length; i++) {
            for (int i1 = 0; i1 < board[0].length; i1++) {
                if (board[i][i1] == '-'){
                    board[i][i1] = 'O';
                }
                if (board[i][i1] == 'O'){
                    board[i][i1] = 'X';
                }
            }
        }
    }

    public static void invild(char[][] board, int i, int j) {
        //如果超出边界，那么直接返回
        if (i < 0 || i >= board.length ||
                j < 0 || j >= board[0].length) {
            return;
        }
        //如果为X也直接返回，无用
        if (board[i][j] == 'X') {
            return;
        }
        //如果为-也直接返回，因为已经转化过了
        if (board[i][j] == '-'){
            return;
        }
        //如果为O那么转化为-
        if (board[i][j] == 'O') {
            board[i][j] = '-';
        }
        //进行深度优先搜素
        invild(board, i + 1, j);
        invild(board, i, j + 1);
        invild(board, i, j - 1);
        invild(board, i - 1, j);
    }
}
