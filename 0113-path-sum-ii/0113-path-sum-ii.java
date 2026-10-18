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
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result= new ArrayList<>();
        traverse(root, new ArrayList<>(),targetSum);
        return result;
    }
    void traverse(TreeNode root, List<Integer> current, int targetSum){
        if(root==null){
            return;
        }
        if(isLeafNode(root)){
            if(targetSum==root.val){
                current.add(root.val);
                result.add(new ArrayList<>(current));
                current.remove(current.size()-1);
            }
            return;
        }
        current.add(root.val);
        traverse(root.left,current,targetSum-root.val);
        traverse(root.right,current,targetSum-root.val);
        current.remove(current.size()-1);
    }
    
    boolean isLeafNode(TreeNode root){
        return root.left==null&&root.right==null;
    }
}