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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,List<Integer>>> map= new TreeMap<>();
        traverse(root,0,0,map);
        List<List<Integer>> result= new ArrayList<>();
        for(TreeMap<Integer,List<Integer>> verticals:map.values()){
            List<Integer> temp= new ArrayList<>();
            for(List<Integer> level:verticals.values()){
                Collections.sort(level);
                temp.addAll(level);
            }
            result.add(temp);
        }
        return result;
    }
    void traverse(TreeNode root, int vertical , int level , TreeMap<Integer,TreeMap<Integer,List<Integer>>> map){
        if(root==null)return;
        if(!map.containsKey(vertical)){
            map.put(vertical,new TreeMap<>());
        }
        if(!map.get(vertical).containsKey(level)){
            map.get(vertical).put(level,new ArrayList<>());
        }
        map.get(vertical).get(level).add(root.val);
        traverse(root.left,vertical-1,level+1,map);
        traverse(root.right,vertical+1,level+1,map);
    }
}