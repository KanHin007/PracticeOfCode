package level.easy;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lawrence
 * 二叉树中序遍历 左- > 中 - > 右
 */
public class InorderTraversal {

    /**
     * 利用递归方式遍历
     * @param node
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode node){
        if(node == null){
            return Collections.emptyList();
        }

        List<Integer> resultList = new ArrayList<>();

        resultList.addAll(inorderTraversal(node.left));
        resultList.add(node.val);
        resultList.addAll(inorderTraversal(node.right));

        return resultList;
    }

    /**
     * 使用非递归方式进行遍历
     * @param node
     * @return
     */
    public static List<Integer> inorderTraversal2(TreeNode node){
        return null;
    }

}
