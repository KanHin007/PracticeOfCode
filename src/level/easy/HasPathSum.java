package level.easy;

import structure.TreeNode;

/**
 * @author lawrence
 * 是否存在目标值在路径上
 */
public class HasPathSum {


    /**
     * 利用递归去不断的获取值，然后相减，然后判断叶节点即可
     * @param treeNode
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode treeNode,int sum){

        if(treeNode == null){
            return false;
        }

        int remain = sum - treeNode.val;

        if(remain == 0 && treeNode.left == null && treeNode.right == null){
            return true;
        } else{
            return hasPathSum(treeNode.left,remain) ||
            hasPathSum(treeNode.right,remain);
        }

    }



}
