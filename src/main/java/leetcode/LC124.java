package main.java.leetcode;

import java.util.*;

/**
 * 124. 二叉树中的最大路径和
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 */
class LC124 {
    public int maxPathSum(TreeNode root) {
        int[] maxRes = new int[1];
        maxRes[0] = Integer.MIN_VALUE;
        dfs(root, maxRes);
        return maxRes[0];
    }

    //返回以root为根的maxGain
    //maxRes用于更新最大路径和
    public int dfs(TreeNode root, int[] maxRes) {
        if (root == null) return 0;

        //update
        int leftGain = dfs(root.left, maxRes);
        int rightGain = dfs(root.right, maxRes);
        int maxPath = root.val + Math.max(leftGain, 0) + Math.max(rightGain, 0);
        maxRes[0] = Math.max(maxPath, maxRes[0]);

        //maxGain
        int maxGain = root.val + Math.max(0, Math.max(leftGain, rightGain));

        return maxGain;
    }

    public class TreeNode {
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

}
