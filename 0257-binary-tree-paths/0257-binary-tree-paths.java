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
    List<String> traversalList;
    public List<String> binaryTreePaths(TreeNode root) {
        traversalList= new ArrayList<>();
        traverseTree(new ArrayList<>(),root);
        return traversalList;
    }
    void traverseTree( List<Integer> currentTraversal, TreeNode currentNode){
        if(currentNode==null){
            return;
        }
        currentTraversal.add(currentNode.val); 

        if(currentNode.left==null&&currentNode.right==null){
            String s ="";
            for(int i=0;i<currentTraversal.size();i++){
                if(i==currentTraversal.size()-1){
                    s+=currentTraversal.get(i);
                }
                else {
                    s+=currentTraversal.get(i)+"->";
                }
            }
            traversalList.add(s);
        }
        // right 
        traverseTree(currentTraversal, currentNode.right);
        // left 
        traverseTree(currentTraversal, currentNode.left);

        currentTraversal.remove(currentTraversal.size()-1);

    }
}