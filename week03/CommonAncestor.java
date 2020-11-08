package com.most.av.videoapp.algorithm;

public class CommonAncestor {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private TreeNode lcn;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return lcn;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean lrn = dfs(root.left, p, q);
        boolean rrn = dfs(root.right, q, p);
        if (lrn && rrn || (root.val == p.val || root.val == q.val && (lrn || rrn))) {
            lcn = root;
        }
        return lrn || rrn || root.val == p.val || root.val == q.val;
    }

}
