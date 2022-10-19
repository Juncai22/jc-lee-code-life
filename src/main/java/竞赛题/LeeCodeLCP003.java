package 竞赛题;

import java.util.*;

public class LeeCodeLCP003 {


    public static void main(String[] args) {
        int[] flowers = {1,2,2,2,2,2,3,2};

        int i = beautifulBouquet(flowers, 1);
        System.out.println(i);
    }

    public static int beautifulBouquet(int[] flowers, int cnt) {
        int ans = 0;
        for (int i = 0; i < flowers.length; i++) {
            ans += flowers.length - i;
            ans = ans == 1000000007 ? 1000000007 : ans % 1000000007;
        }
        int[] sex = new int[1000001];
        for (int flower : flowers) {
            sex[flower]++;
        }
        HashMap<Integer, Integer> map01 = new HashMap<>();
        HashMap<Integer, Queue<Integer>> map02 = new HashMap<>();
        for (int i = sex.length - 1; i >= 0; i--) {
            if (sex[i] > cnt)
                map01.put(i, sex[i]);
        }
        if (map01.size() == 0) return ans;
        int begin = 0;
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < flowers.length; i++) {
            if (map01.containsKey(flowers[i])) {
                if (map02.containsKey(flowers[i])) {
                    Queue<Integer> queue = map02.get(flowers[i]);
                    queue.add(i);
                    map02.put(flowers[i], queue);
                } else {
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(i);
                    map02.put(flowers[i], queue);
                }
            }
            if (map01.containsKey(flowers[i]) && map02.get(flowers[i]).size() > cnt) {
                Queue<Integer> queue1 = map02.get(flowers[i]);
                int poll = queue1.poll();
                map02.put(flowers[i], queue1);
                for (int j = 0; j < flowers.length; j++) {
                    if (j <= poll) {
                        if (map.containsKey(j)) {
                            HashSet<Integer> set = map.get(j);
                            set.add(i);
                            map.put(j,set);
                        } else {
                            HashSet<Integer> set = new HashSet<>();
                            set.add(i);
                            map.put(j,set);
                        }
                    }else if (j >= i){
                        if (map.containsKey(poll)) {
                            HashSet<Integer> set = map.get(poll);
                            set.add(j);
                            map.put(poll,set);
                        } else {
                            HashSet<Integer> set = new HashSet<>();
                            set.add(j);
                            map.put(poll,set);
                        }
                    }
                }
                for (int j = begin; j <= poll; j++) {
                    Queue<Integer> queue2 = map02.get(flowers[i]);
                    queue2.poll();
                    map02.put(flowers[i], queue2);
                }
                begin = poll + 1;
            }
        }
        int temp = 0;
        for (HashSet<Integer> value : map.values()) {
            temp += value.size();
        }
        return ans - temp;
    }
}
