package 数学思维2;


/**
 * 1072. 按列翻转得到最大值等行数
 * LeeCode 1072
 * 难度 ： 中等
 */
public class LeeCode1072TOCHANGE {

    public static void main(String[] args) {
        int[][] martrix = {{0, 0, 0}, {0, 0, 1}, {1, 1, 0}};
        maxEqualRowsAfterFlips(martrix);
    }

    public static int maxEqualRowsAfterFlips(int[][] matrix) {
        int res = 1, n = matrix[0].length;
        Node root = new Node();
        for (int i = 0; i < matrix.length; i++) {
            Node curr = root;
            for (int j = 0; j < n; j++) {
                int k = matrix[i][0] == 0 ? matrix[i][j] : matrix[i][j] ^ 1;
                if (curr.child[k] == null) curr.child[k] = new Node();
                curr = curr.child[k];
            }
            res = Math.max(res, ++curr.count);
        }
        return res;
    }

    static class Node {
        Node[] child = new Node[2];
        int count;
    }
}

