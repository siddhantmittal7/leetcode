package com.company.Utility;

public class TreeHelper {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public TreeNode createTree(int[] nums){

        TreeNode[] treeNodeArray = new TreeNode[nums.length];

        for(int i=0;i<nums.length;i++) {
            TreeNode node = new TreeNode(nums[i]);
            treeNodeArray[i] = node;
        }
        for(int i=0;i<treeNodeArray.length;i++) {
            TreeNode node =treeNodeArray[i];
            if(2*i<nums.length){
                node.left = new TreeNode(nums[2*i]);
            }else{
                node.left = null;
            }
            if(2*i+1<nums.length){
                node.right = new TreeNode(nums[2*i + 1]);
            }else{
                node.right = null;
            }
        }

        return treeNodeArray[0];
    }
}
