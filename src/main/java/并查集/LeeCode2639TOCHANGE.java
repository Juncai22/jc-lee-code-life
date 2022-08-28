package 并查集;


import java.util.HashMap;
import java.util.HashSet;

/**
 * 剑指 Offer II 116. 省份数量
 * LeeCode 2639
 * 难度 ： 中等
 */
public class LeeCode2639TOCHANGE {

    int mergedCount = 0;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(isConnected);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) uf.union(i, j);
            }
        }
        return n - mergedCount;
    }

    private class UnionFind {
        private int[] parents;
        private int[] rank;

        public UnionFind(int[][] isConnected) {
            int n = isConnected.length;
            this.parents = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
                rank[i] = 1;
            }
        }

        // 带路径压缩的查找
        public int find(int x) {
            if (parents[x] == x) return x;
            return parents[x] = find(parents[x]);
        }

        // 按秩合并
        public void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot != yRoot) {
                mergedCount++; // 只有不属于一个集合时，合并才次数加1
                if (rank[yRoot] <= rank[xRoot]) parents[yRoot] = xRoot;// yRoot挂到xRoot上
                else parents[xRoot] = yRoot; // xRoot挂到yRoot上
                if (rank[xRoot] == rank[yRoot]) rank[xRoot]++; // 秩相同时才加1
            }
        }
    }
}
