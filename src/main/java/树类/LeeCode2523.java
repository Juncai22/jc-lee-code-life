package 树类;


import java.util.*;

/**
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 * LeeCode 2523
 * 难度 ： 中等
 */
public class LeeCode2523 {


    public int[] levelOrder(TreeNodem root) {
        //首先使用队列，先进先出
        Queue<TreeNodem> queue = new LinkedList<>();
        //因为是可变的所已使用ilst
        List<Integer> ans = new ArrayList<>();
        //首先进行root的进入
        queue.add(root);
        //for循环，有一个算一个，直接计算
        while (queue.size() != 0) {
            TreeNodem poll = queue.poll();
            if (poll.left != null) queue.add(poll.left);
            if (poll.right != null) queue.add(poll.right);
            ans.add(poll.val);
        }
        //返回
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }


    public class TreeNodem {
        int val;
        TreeNodem left;
        TreeNodem right;

        TreeNodem(int x) {
            val = x;
        }
    }
}
