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
    int maxSum;
    public int maxSumBST(TreeNode root) {
        maxSum=0;
        traverse(root);
        return maxSum;
    }
    public  NodeValue traverse(TreeNode root){
        if(root==null)return new NodeValue(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        
        NodeValue left= traverse(root.left);
        NodeValue right= traverse(root.right);
        
        if(root.val>left.max&&root.val<right.min){
            int sum=left.sum+right.sum+root.val;
            
            maxSum=Math.max(sum,maxSum);
            return new NodeValue(Math.min(left.min,root.val),Math.max(root.val,right.max),sum);
        }
        
        return new NodeValue(Integer.MIN_VALUE,Integer.MAX_VALUE, 0);
    }
}
class NodeValue{
    int min;
    int max;
    int sum;
    public NodeValue(int min, int max, int sum){
        this.min=min;
        this.max=max;
        this.sum=sum;
    }
}