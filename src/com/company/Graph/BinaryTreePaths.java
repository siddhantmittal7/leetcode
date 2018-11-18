package com.company.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class BinaryTreePaths {

    public static class TreeNode {
        int val;
        BinaryTreePaths.TreeNode left;
        BinaryTreePaths.TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static List<String> binaryTreePaths(TreeNode root) {

        List<String> pathList = new ArrayList<String>();
        Stack<TreeNode> s = new Stack<TreeNode>();

        String leafPath = "";

        if(root == null){
            return pathList;
        }

        TreeNode mainRoot = root;


        HashMap<TreeNode,Boolean> visited = new HashMap<TreeNode,Boolean>();

        while(true){

            leafPath = leafPath + String.valueOf(root.val);

            if(root.left == null && root.right == null){
                pathList.add(leafPath);
                root = mainRoot;
                leafPath = "";
                leafPath = leafPath + String.valueOf(root.val);
            }

                if(root.left != null && !visited.containsKey((root.left))){
                    root = root.left;
                    visited.put(root,true);
                }else if(root.right != null && !visited.containsKey((root.right))){
                        root = root.right;
                    visited.put(root,true);
                }else{
                    break;
                }

        }

        return pathList;
    }

    public static void main(String[] args){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.right = node2;

        List<String> ll = binaryTreePaths(node1);

    }
}
