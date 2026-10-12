/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String result="";
        if(root==null)return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            TreeNode node=queue.poll();
            if(node==null)
            {
                result+="n ";
                continue;
            }
            result+=node.val+" ";
            queue.offer(node.left);
            queue.offer(node.right);
        }
        return result;

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0)return null;
        Queue<TreeNode> q= new LinkedList<>();
        String [] arr=data.split(" ");
        TreeNode root= new TreeNode(Integer.parseInt(arr[0]));
        q.offer(root);
        int i=1;
         while(!q.isEmpty()){ 
             TreeNode temp=q.poll();
             if(!arr[i].equals("n"))
             {
                 TreeNode left= new TreeNode(Integer.parseInt(arr[i]));
                 temp.left=left;
                 q.add(left);
             }
             if(!arr[++i].equals("n"))
             {
                 TreeNode right= new TreeNode(Integer.parseInt(arr[i]));
                 temp.right=right;
                 q.add(right);
             }
             i++;
         }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));