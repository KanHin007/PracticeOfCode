package level.easy;

import structure.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lawrence
 * 2019.02.23
 *
 * 141.环形链表
 *
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *
 *
 *
 *
 * 进阶：
 *
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 *
 */
public class HasCycle {


    /**
     * 利用快慢指针，如果快指针和慢指针相等说明相交了，就是有环
     * @param head 头节点
     * @return 是否
     */
    public static boolean hasCycle(ListNode head) {

        ListNode quick = head;
        ListNode slow = head;

        //循环判断一下当前的slow是不是为空 ，quick是不是为空 quick.next是不是空
        while(slow != null && quick != null && quick.next != null ){

            slow = slow.next;
            quick = quick.next.next;

            if(slow == quick){
                return true;
            }

        }

        return false;

    }


    /**
     * 利用set存储节点信息 用contains来获得是否存入
     * @param head 头节点
     * @return 是否
     */
    public static boolean hasCycle2(ListNode head) {

        ListNode temp = head;
        Set<ListNode> sets = new HashSet<>();
        while(temp != null){
            if(!sets.contains(temp)){
                sets.add(temp);
            }else{
                return true;
            }
            temp = temp.next;
        }

        return false;

    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(3);
        ListNode temp = new ListNode(2);
        l1.next = temp;
        l1.next.next = new ListNode(0);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = temp;

        System.out.println(hasCycle(l1));

        System.out.println(hasCycle2(l1));

    }






}
