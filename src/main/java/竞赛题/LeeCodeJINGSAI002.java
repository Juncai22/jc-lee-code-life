package 竞赛题;


import java.util.HashSet;

/**
 * 002. 交通枢纽
 * LeeCode 002
 * 难度 ： 中等
 */
public class LeeCodeJINGSAI002 {

    public static void main(String[] args) {
        int[][] path = {{2, 5}, {4, 3}, {2, 3}};
        transportationHub(path);
    }

    public static int transportationHub(int[][] path) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set1 = new HashSet<>();

        for (int[] ints : path) {
            set.add(ints[0]);
            set.add(ints[1]);
            set1.add(ints[0]);
            set1.add(ints[1]);
        }
        for (int[] ints : path) {
            if (set.contains(ints[0])) set1.remove(ints[0]);
        }
        for (Integer integer : set1) {
            int min = 0;
            for (int[] ints : path) {
                if (ints[1] == integer) {
                    min++;
                }
            }
            if (min == set.size() - 1) return integer;
        }
        return -1;
    }
}
