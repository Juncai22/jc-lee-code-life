package 数学思维2;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * LeeCode 94
 * 难度 ： 简单
 */
public class LeeCode94 {


    public List<Integer> inorderTraversal(TreeNode03 root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode03> stack = new Stack<>();
        TreeNode03 cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.add(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                ans.add(cur.val);
                cur = cur.right;
            }
        }
        return ans;
    }


    public class TreeNode03 {
        int val;
        TreeNode03 left;
        TreeNode03 right;

        TreeNode03() {
        }

        TreeNode03(int val) {
            this.val = val;
        }

        TreeNode03(int val, TreeNode03 left, TreeNode03 right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
