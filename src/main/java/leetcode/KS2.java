package leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 二叉树层次遍历
 */
public class KS2 {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        LinkedList<TreeNode> que = new LinkedList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        que.add(root);

        while (!que.isEmpty()) {
            ArrayList<Integer> list2 = new ArrayList<>();
            for (int n = que.size(); n > 0; n--) {
                TreeNode cur = que.removeFirst();
                list2.add(cur.val);
                if (cur.left != null) que.addLast(cur.left);
                if (cur.right != null) que.addLast(cur.right);
            }
            list.add(list2);
        }


        return list;


    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @Test
    public void test() {
        TreeNode head = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        head.left = node2;
        head.right = node3;
        node2.left = node4;

        System.out.println(levelOrder(head));
    }

}