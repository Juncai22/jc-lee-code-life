package 数学思维2;


import java.util.ArrayList;
import java.util.List;

/**
 * 222. 完全二叉树的节点个数
 * LeeCode 222
 * 难度 ： 中等
 */
public class LeeCode222 {

    public int countNodes(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        quck(list, root);
        return list.size();
    }

    public void quck(List<Integer> list, TreeNode root) {
        if (root == null) return;
        list.add(root.val);
        quck(list, root.left);
        quck(list, root.right);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}