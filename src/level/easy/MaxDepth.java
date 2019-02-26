package level.easy;

import structure.TreeNode;

/**
 * @author lawrence
 * 2019.02.27
 * 二叉树最大深度
 */
public class MaxDepth {


    /**
     * 递归求二叉树最大深度
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root){
        if (root == null) {
            return 0;
        } else {
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return java.lang.Math.max(left_height, right_height) + 1;
        }
    }

}
