//给定一棵二叉搜索树，请找出其中第k大的节点。 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 1 ≤ k ≤ 二叉搜索树元素个数 
// Related Topics 树 
// 👍 164 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private static int index;
    private static int res;
    public int kthLargest(TreeNode root, int k) {
        index = 0;
        res = 0;
        inorder(root,k);
        return res;
    }
    private void inorder(TreeNode root,int k){
        if (index > k){
            return;
        }
        if (root == null){
            return;
        }
        inorder(root.right,k);
        index++;
        if(index == k){
            res = root.val;
            return;
        }
        inorder(root.left,k);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
