class Solution {

    class Pair {
        int height;
        int diameter;

        Pair(int height,int diameter) {
            this.height=height;
            this.diameter=diameter;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        return findmax(root).diameter;
    }

    private Pair findmax(TreeNode root){
        if (root==null){
            return new Pair(0,0);
        }
        Pair left=findmax(root.left);
        Pair right=findmax(root.right);

        int height=1+Math.max(left.height,right.height);
        int diameterThroughRoot=left.height+right.height;
        int diameter=Math.max(diameterThroughRoot,Math.max(left.diameter, right.diameter));

        return new Pair(height, diameter);
    }
}