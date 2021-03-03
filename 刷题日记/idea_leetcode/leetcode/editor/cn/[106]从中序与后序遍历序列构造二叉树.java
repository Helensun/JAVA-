//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组 
// 👍 447 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 使用递归的方法
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(inorder, 0, inorder.length , postorder, 0, postorder.length , map);
    }

    public TreeNode helper(int[] inorder, int inorderLeft, int inorderRight, int[] postorder, int postorderLeft, int postorderRight, HashMap<Integer, Integer> map) {
        if (inorderLeft == inorderRight) {
            return null;
        }
        if (inorderRight-inorderLeft==1){
            return new TreeNode(inorder[inorderLeft]);
        }
        int endTmp = postorder[postorderRight-1];
        Integer index = map.get(endTmp);
        TreeNode root = new TreeNode(endTmp);
        int inorderLeftNumber = index - inorderLeft;
        int inorderRightNumber = inorderRight - index-1;
        root.left = helper(inorder, inorderLeft, inorderLeft + inorderLeftNumber, postorder, postorderLeft, postorderLeft + inorderLeftNumber, map);
        root.right = helper(inorder, index + 1, index + 1 + inorderRightNumber, postorder, postorderRight - inorderRightNumber-1, postorderRight-1, map);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
