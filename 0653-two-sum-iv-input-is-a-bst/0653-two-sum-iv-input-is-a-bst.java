 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        return inorder(root, root, k);
    }
    boolean search(TreeNode root, int key){
        while(root!=null){
            if(root.val==key)return true;
            root=key<root.val?root.left:root.right;
        }
        return false;
    }

    boolean inorder(TreeNode node,TreeNode root, int k){
        if (node==null)return false;

        return inorder(node.left,root,k)
            ||(node.val*2!=k&&search(root,k-node.val))
            ||inorder(node.right,root,k);
    }
}