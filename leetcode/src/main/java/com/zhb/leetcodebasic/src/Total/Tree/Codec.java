package com.zhb.leetcodebasic.src.Total.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2021/1/7 9:46
 */
public class Codec {
    public static void main(String[] args) {
        String s="1,1,1,1,1,1,2,";
        String[] data_array = s.split(",");
        System.out.println();
    }

    public String rserialize(TreeNode root, String str) {
        if (root == null) {
            str += "None,";
        } else {
            str += str.valueOf(root.val) + ",";
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        return str;
    }

    public String serialize(TreeNode root) {
        return rserialize(root, "");
    }

    public TreeNode rdeserialize(List<String> l) {
        if (l.get(0).equals("None")) {
            l.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = rdeserialize(l);
        root.right = rdeserialize(l);

        return root;
    }
    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
        return rdeserialize(data_list);
    }


}