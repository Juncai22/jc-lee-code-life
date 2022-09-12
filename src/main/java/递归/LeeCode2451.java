package 递归;


import java.util.HashSet;

/**
 * LCP 44. 开幕式焰火
 * LeeCode 2451
 * 难度 ： 简单
 */
public class LeeCode2451 {

    HashSet<Integer> hashSet = new HashSet<>();

    public int numColor(TreeNode root) {
        dfs(root);
        return hashSet.size();
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        if (!hashSet.contains(root.val)) hashSet.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
