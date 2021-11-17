package com.zhb.leetcodebasic.src.Total.Tree;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2021/1/7 8:51
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}