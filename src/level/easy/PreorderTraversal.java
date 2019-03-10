package level.easy;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lawrence
 * 二叉树前序遍历 主- > 左 - > 右
 */
public class PreorderTraversal {

    /**
     * 利用递归方式遍历
     * @param node
     * @return
     */
    public static List<Integer> preorderTraversal(TreeNode node){
        if(node == null){
            return Collections.emptyList();
        }

        List<Integer> resultList = new ArrayList<>();

        resultList.add(node.val);
        resultList.addAll(preorderTraversal(node.left));
        resultList.addAll(preorderTraversal(node.right));


        return resultList;
    }

    /**
     * 使用非递归方式进行遍历
     * @param node
     * @return
     */
    public static List<Integer> preorderTraversal2(TreeNode node){
        return null;
    }

}
