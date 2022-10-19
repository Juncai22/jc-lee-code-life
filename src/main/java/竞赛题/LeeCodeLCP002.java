package 竞赛题;

public class LeeCodeLCP002 {

    public TreeNode002 expandBinaryTree(TreeNode002 root) {
        if (root.left != null) {
            TreeNode002 left = root.left;
            root.left = new TreeNode002(-1);
            root.left.left = left;
            expandBinaryTree(left);
        }
        if (root.right != null){
            TreeNode002 right = root.right;
            root.right = new TreeNode002(-1);
            root.right.right = right;
            expandBinaryTree(right);
        }
        return root;

    }


}


class TreeNode002 {
    int val;
    TreeNode002 left;
    TreeNode002 right;
    TreeNode002() {}
    TreeNode002(int val) { this.val = val; }
    TreeNode002(int val, TreeNode002 left, TreeNode002 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

