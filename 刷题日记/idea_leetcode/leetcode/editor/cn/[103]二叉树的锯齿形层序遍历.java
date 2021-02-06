//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 381 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.*/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // 使用间隔符
        LinkedList<Integer> array = new LinkedList<>();
        LinkedList<TreeNode> tmp1 = new LinkedList<>();
        tmp1.add(root);
        while (tmp1.size()>0){
            LinkedList<TreeNode> tmp2 = new LinkedList<>();
            tmp1.forEach(item-> array.add(item.val));
            array.add(null);
            while (tmp1.size()>0){
                TreeNode pop = tmp1.pop();
                if (pop.left!=null){
                    tmp2.push(pop.left);
                }
                if (pop.right!=null){
                    tmp2.push(pop.right);
                }
            }
            tmp1 = tmp2;
        }
        System.out.println(array);
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
