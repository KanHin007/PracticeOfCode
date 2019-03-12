package level.easy;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author lawrence
 * 判断是否为对称二叉树
 */
public class IsSymmetric {


    /**
     * 利用递归调用左右子树的节点进行判断
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);


    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left != null && right == null || left == null && right != null || left.val != right.val) {
            return false;
        }

        //精华在这里 用左子树的左节点与右子树的右节点判断，用左子树的右节点与右子树的左节点进行判断 并不断的递归
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);

    }


}
