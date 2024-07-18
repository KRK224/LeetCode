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
    public int countPairs(TreeNode root, int distance) {
        return postOrder(root, distance)[11];
        
    }

    public int[] postOrder(TreeNode currentNode, int distance) {
        if(currentNode == null)
            return new int[12];
        if (currentNode.left == null && currentNode.right == null) {
            // leat Node
            int[] result = new int[12];
            result[0] = 1;
            return result;
        }
        int[] result = new int[12];
        int[] left = postOrder(currentNode.left, distance);
        int[] right = postOrder(currentNode.right, distance);

        for(int d=0; d<10; d++) {
            // get leafNode count from left and right
            result[d+1] = left[d] + right[d];
        }
        result[11] = left[11] + right[11];
        for(int d1=0; d1<11; d1++) {
            for(int d2=0; d2<11; d2++) {
                if(d1+d2+2 <= distance) {
                    result[11] += left[d1] * right[d2];
                }
            }
        }

        return result;
    }
}