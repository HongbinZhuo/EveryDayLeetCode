package Total.Tree;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2021/1/7 9:14
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p == root || q == root) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) return right;
        if (right == null) return left;
        if (right != null && left != null) return root;

        return null;

    }



    TreeNode ans;
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
       this.dfs(root, p, q);
       return  this.ans;
    }
    public   boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return false;
        }
        boolean left=dfs( root.left,  p, q);
        boolean right=dfs( root.right,  p, q);

        if(left&&right ||  root.val==q.val||root.val==p.val)
            ans =root;
        return left || right || (root.val == p.val || root.val == q.val);
    }


}
