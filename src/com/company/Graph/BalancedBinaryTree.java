package com.company.Graph;

import com.company.Utility.TreeHelper;

import java.util.HashMap;
import java.util.Queue;
import java.util.Stack;

public class BalancedBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    private int height(TreeNode root){
        if(root == null)
            return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        if(lh == -1 || rh == -1 || Math.abs(lh-rh)>1)
            return -1;

        return Math.max(lh,rh)+1;
    }
}
