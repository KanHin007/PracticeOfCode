package level.middle;

import structure.ListNode;

/**
 * @author lawrence
 * 2019.02.20
 * <p>
 * 2.链表形式的两数相加
 * <p>
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {


    /**
     * 遍历两个节点，然后相加形成一个新的链表
     *
     * @param l1 第一个节点
     * @param l2 第二个节点
     * @return 返回新生成的节点
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode listNode = new ListNode(0);
        ListNode result = listNode;

        int factor = 0;
        // 判读l1 和 l2链表的下一个指针都不为null
        while (l1 != null && l2 != null) {

            int temp = l1.val + l2.val + factor;

            factor = temp / 10;

            listNode.next = new ListNode(temp % 10);
            l1 = l1.next;
            l2 = l2.next;
            listNode = listNode.next;

        }
        ListNode l3 = null;
        if (l1 != null) {
            l3 = l1;
        } else if (l2 != null) {
            l3 = l2;
        }
        while (l3 != null) {

            int temp = l3.val + factor;

            listNode.next = new ListNode(temp % 10);

            factor = temp / 10;

            listNode = listNode.next;

            l3 = l3.next;

        }

        if (factor != 0) {
            listNode.next = new ListNode(1);
        }

        return result.next;
    }


    /**
     * 官方给予的解决方案
     * 代码写的比我的简洁一些 直接利用while循环来做
     *
     * 注意这里直接把没有的后续链表模拟成value=0
     *
     * @param l1 第一个列表
     * @param l2 第二个列表
     * @return 新生成的列表
     */
    public static ListNode addTwoNumbersImprove(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }


    public static void main(String[] args) {
        /*ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);*/


        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);

        ListNode l2 = new ListNode(0);


        ListNode result = addTwoNumbers(l1, l2);

        System.out.println(result.val + " : " + result.next.val + " : " + result.next.next.val);
    }
}
