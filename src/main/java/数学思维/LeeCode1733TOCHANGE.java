package 数学思维;


import java.util.*;
import java.util.function.BiFunction;

/**
 * 1733. 需要教语言的最少人数
 * LeeCode 1733
 * 难度 ： 中等
 */
public class LeeCode1733TOCHANGE {

    public static void main(String[] args) {
    }

    public static int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        // 记录哪些人不能够相互交流
        Set<Integer> unableGroup = new HashSet<>();

        // 检查 a 和 b 能不能交流
        BiFunction<Integer, Integer, Boolean> check = (a, b) -> {
            for (int x : languages[a])
                for (int y : languages[b])
                    if (x == y)
                        return true;
            return false;
        };

        // 将不能相互交流的人记录到集合中
        for (int[] friendship : friendships) {
            int u = friendship[0] - 1;
            int v = friendship[1] - 1;
            if (!check.apply(u, v)) {
                unableGroup.add(u);
                unableGroup.add(v);
            }
        }
        // 找到这些人中共同会的最多的语言
        Map<Integer, Integer> language = new HashMap<>();
        int max = 0;
        for (int u : unableGroup) {
            for (int x : languages[u]) {
                language.put(x, language.getOrDefault(x, 0) + 1);
                max = Math.max(language.get(x), max);
            }
        }
        // 需要学习的人数就是这批人的总数减去最大会的人数
        return unableGroup.size() - max;
    }
}
