package 数学思维;


/**
 * 789. 逃脱阻碍者
 * LeeCode 789
 * 难度 ： 中等
 */
public class LeeCode789 {

    public static void main(String[] args) {

        int[][] ghosts = {{1, 9}, {2, -5}, {3, 8}, {9, 8}, {-1, 3}};
        int[] target = {8, -10};
        boolean b = escapeGhosts(ghosts, target);
        System.out.println(b);
    }

    public static boolean escapeGhosts(int[][] ghosts, int[] target) {
        if (ghosts == null && ghosts.length == 0) {
            return true;
        }
        int size = toTarget(ghosts[0], target);
        for (int[] ghost : ghosts) {
            int tempInt = toTarget(target, ghost);
            size = Math.min(tempInt, size);
        }
        int[] begin = {0, 0};
        int ansTarget = toTarget(target, begin);

        return ansTarget < size;
    }

    public static int toTarget(int[] target, int[] begin) {
        int size = begin[0] > target[0] ? begin[0] - target[0] : target[0] - begin[0];
        size += begin[1] > target[1] ? begin[1] - target[1] : target[1] - begin[1];
        return size;
    }
}
