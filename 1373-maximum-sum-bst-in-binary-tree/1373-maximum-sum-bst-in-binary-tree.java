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
    public int maxSumBST(TreeNode root) {
        int maxSum= traverse(root).maxSum;
        return maxSum>0?maxSum:0;
    }
    private static NodeValue traverse(TreeNode root){
        if(root==null)return new NodeValue(Integer.MAX_VALUE,Integer.MIN_VALUE,0,0);
        
        NodeValue left= traverse(root.left);
        NodeValue right= traverse(root.right);
        
        int sum= left.sum+right.sum+root.val;
        int min= Math.min(left.min,root.val);
        int max = Math.max(right.max, root.val);
        int maxSum=Math.max(sum, Math.max(left.maxSum, right.maxSum));
        
        if(root.val>left.max&&root.val<right.min){
            return new NodeValue(min, max,sum,maxSum);
        }
        
        return new NodeValue(Integer.MIN_VALUE,Integer.MAX_VALUE,0, Math.max(left.maxSum,right.maxSum));
    }
}
class NodeValue{
    int min;
    int max;
    int sum;
    int maxSum;
    public NodeValue(int min, int max, int sum, int maxSum){
        this.min=min;
        this.max=max;
        this.sum=sum;
        this.maxSum=maxSum;
    }
}