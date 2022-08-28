package 竞赛题.第308场周赛;


import java.util.*;

/**
 * 6163. 给定条件下构造矩阵
 * LeeCode 6163
 * 难度 ： 困难
 */
public class LeeCodeJINGSAI6163 {

    public static void main(String[] args) {
        List<Integer> air = new ArrayList<>();
        air.add(1);
        air.add(0, 2);
        for (int i = 0; i < air.size(); i++) {
            System.out.println(air.get(i));
        }
    }

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        // 在行方向进行 k 个数字的拓扑排序
        // row 数组记录行下标的分配情况
        int[] row = new int[k + 1];
        // 记录入度
        int[] indegree = new int[k + 1];
        // 构建图
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= k; i++)
            graph.add(new ArrayList<>());
        // HashSet 记录参与拓扑排序的数字数目（不是所有数字都有拓扑关系约束）
        HashSet<Integer> set = new HashSet<>();
        for (int[] x : rowConditions) {
            set.add(x[0]);
            set.add(x[1]);
            graph.get(x[0]).add(x[1]);
            indegree[x[1]]++;
        }
        int size = set.size();
        // 将入度为 0 的数字入队
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= k; i++)
            if (indegree[i] == 0)
                queue.offer(i);
        // 从 1 开始分配下标（方便后续通过 0 来判断数字是否分配了下标），一般的拓扑排序
        int current = 1;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            row[u] = current++;
            for (int v : graph.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0)
                    queue.offer(v);
            }
        }
        // current - 1 是当前分配了下标的数字数目，如果和参与拓扑排序的数字个数不同，就说明分配失败（有环），返回空矩阵
        if (current - 1 < size)
            return new int[0][0];
        // 有些数字没有拓扑关系约束，任意分配一个下标
        for (int i = 1; i <= k; i++)
            if (row[i] == 0)
                row[i] = current++;
        // 在列方向进行 k 个数字的拓扑排序，和行方向上的处理方式一致
        int[] col = new int[k + 1];
        graph.clear();
        set.clear();
        Arrays.fill(indegree, 0);
        for (int i = 0; i <= k; i++)
            graph.add(new ArrayList<>());
        for (int[] x : colConditions) {
            set.add(x[0]);
            set.add(x[1]);
            graph.get(x[0]).add(x[1]);
            indegree[x[1]]++;
        }
        size = set.size();
        queue.clear();
        for (int i = 1; i <= k; i++)
            if (indegree[i] == 0)
                queue.offer(i);
        current = 1;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            col[u] = current++;
            for (int v : graph.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0)
                    queue.offer(v);
            }
        }
        if (current - 1 < size)
            return new int[0][0];
        for (int i = 1; i <= k; i++)
            if (col[i] == 0)
                col[i] = current++;
        // 根据行方向和列方向上的下标分配关系填充矩阵
        int[][] res = new int[k][k];
        for (int i = 1; i <= k; i++)
            res[row[i] - 1][col[i] - 1] = i;
        return res;
    }
}
