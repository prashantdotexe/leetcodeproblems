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
    public TreeNode sortedArrayToBST(int[] nums) {
        int n=nums.length;
        int mid=n/2;
        TreeNode root= new TreeNode(nums[mid]);
        if(nums.length==1)return root;
        root.left=constructTree(nums,0,mid-1);
        root.right= constructTree(nums,mid+1,n-1);
        return root;
    }
    TreeNode constructTree(int [] nums, int left, int right){
        if(left>right||left<0||right>=nums.length)return null;
        int mid=(left+right)/2;
        TreeNode root= new TreeNode(nums[mid]);
        root.left=constructTree(nums,left,mid-1);
        root.right= constructTree(nums, mid+1, right);
        return root;
    }
}