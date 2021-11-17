package com.zhb.leetcodebasic.src.Total.Tree;

import java.util.ArrayList;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2021/1/7 8:44
 */
//给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
public class KthSmallest {

    public static int kthSmallest(TreeNode root, int k) {
     ArrayList<Integer> nums= inorder(root,new ArrayList<Integer>());
     return  nums.get(k-1);
    }

    public  static ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) return arr;
        //中序遍历
        //左子树
        inorder(root.left, arr);
        //中
        arr.add(root.val);
        //右子树
        inorder(root.right, arr);
        return arr;
    }



    public static int kthSmallest2(TreeNode root, int k) {
        int leftNodeNum = number(root.left);
        if (leftNodeNum >= k) {
            return kthSmallest2(root.left, k);
        } else if (leftNodeNum + 1 == k) {
            return  root.val;
        }else{
            return  kthSmallest(root.right,k-leftNodeNum-1);
        }

    }

    private static int number(TreeNode root) {
        if(root==null) return 0;
        return number(root.left)+number(root.right)+1;
    }


}
