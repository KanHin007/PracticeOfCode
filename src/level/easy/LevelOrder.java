package level.easy;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lawrence
 * 层序遍历
 */
public class LevelOrder {


    /**
     * 利用队列实现
     * 判断队列中的元素有没有子节点，
     * 每次判断都出队
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return Collections.emptyList();
        }

        //创建结果队列
        List<List<Integer>> resultList = new ArrayList<>();

        //创建存储的树节点队列
        LinkedList<TreeNode> treeNodeStoreList = new LinkedList<>();

        //将root节点加入进去
        treeNodeStoreList.add(root);

        //当前队列不为空就继续循环判断
        while (!treeNodeStoreList.isEmpty()) {

            TreeNode treeNode = null;
            //存储当前层的节点
            List<TreeNode> tempList = new ArrayList<>();
            //存储当前层的数据（有点冗余）
            List<Integer> tempIntegerList = new ArrayList<>();

            //不断弹出节点 直到为空
            while ((treeNode = treeNodeStoreList.pollFirst()) != null) {

                //有左节点就添加
                if (treeNode.left != null) {
                    tempList.add(treeNode.left);
                }
                //有右节点就添加
                if (treeNode.right != null) {
                    tempList.add(treeNode.right);
                }

                //添加当前层的node的val数据
                tempIntegerList.add(treeNode.val);

            }

            //将当前层的所有子节点都添加进去继续判断
            treeNodeStoreList.addAll(tempList);

            //将当前层的数据直接加入到结果集中
            resultList.add(tempIntegerList);
        }


        return resultList;
    }


    //todo 想一下另一种方法求解
}
