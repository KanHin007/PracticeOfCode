package level.easy;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lawrence
 * 二叉树后序遍历 左- > 右 - > 中
 */
public class PostorderTraversal {

    /**
     * 利用递归方式遍历
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal(TreeNode root){
        if(root == null){
            return Collections.emptyList();
        }

        List<Integer> resultList = new ArrayList<>();

        resultList.addAll(postorderTraversal(root.left));
        resultList.addAll(postorderTraversal(root.right));
        resultList.add(root.val);

        return resultList;
    }

    /**
     * 使用非递归方式进行遍历
     * @param node
     * @return
     */
    public static List<Integer> postorderTraversal2(TreeNode node){
        return null;
    }

}
