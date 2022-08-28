package DFS深度优先搜索;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 面试题 16.19. 水域大小
 * LeeCode 2711
 * 难度 ： 中等
 */
public class LeeCode2711 {

    public static void main(String[] args) {
        int[][] lans = {{0, 2, 1, 0}, {0, 1, 0, 1}, {1, 1, 0, 1}, {0, 1, 0, 1}};
        int[] ints = pondSizes(lans);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static int[] pondSizes(int[][] land) {
        List<Integer> list = new ArrayList<>();

        int hlight = land.length;
        int wlight = land[0].length;

        //进行for循环让h，w进行验算
        for (int h = 0; h < hlight; h++) {
            for (int w = 0; w < wlight; w++) {
                int count = toCount(h, w, land);
                if (count != 0) {
                    list.add(count);
                }
            }
        }

        //需要从小到大排序，所以先将list转换为数组，然后再进行排序；
        int[] ans = list.stream().mapToInt(Integer::valueOf).toArray();
        Arrays.sort(ans);
        return ans;
    }

    private static int toCount(int h, int w, int[][] land) {
        //简单的dfs优先搜索
        int ans = 0;
        if ((h < 0 || h >= land.length) || (w < 0 || w >= land[0].length) || (land[h][w] != 0)) return ans;

        ans++;
        land[h][w] = -1;

        //遍历上下左右，斜上下左右 
        ans += toCount(h + 1, w, land);
        ans += toCount(h - 1, w, land);
        ans += toCount(h + 1, w + 1, land);
        ans += toCount(h - 1, w - 1, land);
        ans += toCount(h + 1, w - 1, land);
        ans += toCount(h - 1, w + 1, land);
        ans += toCount(h, w + 1, land);
        ans += toCount(h, w - 1, land);

        return ans;
    }
}
