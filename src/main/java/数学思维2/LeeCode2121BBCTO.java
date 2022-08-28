package 数学思维2;


import java.util.*;

/**
 * 890. 查找和替换模式
 * LeeCode 890
 * 难度 ： 中等
 */
public class LeeCode2121BBCTO {

    public long[] getDistances(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        long[] ans = new long[arr.length];
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i]))
                map.get(arr[i]).add(i);
            else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(arr[i], list);
            }
            set.add(arr[i]);
        }
        for (Integer temp : set) {
            List<Integer> list = map.get(temp);
            for (int i = 1; i < list.size(); ++i) {
                ans[list.get(0)] += list.get(i) - list.get(0);
            }
            for (int i = 1; i < list.size(); ++i) {
                ans[list.get(i)] = ans[list.get(i - 1)];
                // i-1 左边的元素全部加上了两者之间的间隔
                ans[list.get(i)] += (long) (i - 1) * (list.get(i) - list.get(i - 1));
                // i   右边的元素全部减去了两者之间的间隔
                ans[list.get(i)] -= (long) (list.size() - i - 1) * (list.get(i) - list.get(i - 1));
            }
        }
        return ans;
    }


    public long[] getDistances2(int[] arr) {
        int n = arr.length;
        long[] ans = new long[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        for (List<Integer> list : map.values()) {
            int m = list.size();
            for (int i = 1; i < m; ++i) {
                ans[list.get(0)] += list.get(i) - list.get(0);
            }
            for (int i = 1; i < m; ++i) {
                ans[list.get(i)] = ans[list.get(i - 1)];
                // i-1 左边的元素全部加上了两者之间的间隔
                ans[list.get(i)] += (long) (i - 1) * (list.get(i) - list.get(i - 1));
                // i   右边的元素全部减去了两者之间的间隔
                ans[list.get(i)] -= (long) (m - i - 1) * (list.get(i) - list.get(i - 1));
            }
        }
        return ans;
    }
}
