package code;

import java.util.List;

// 反转链表
public class Solution206 {
    // 方法1：迭代
    public ListNode reverseList1(ListNode head) {
        /*
         * */
        ListNode preNode = null;
        ListNode curNode = head;
        while (curNode != null) {
            ListNode nextNode = curNode.next; // 在反转之前，需要把下一个要遍历的节点临时存储起来
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }

        return preNode;
    }

    // 方法2：递归
    public ListNode reverseList2(ListNode head) {
        /*
        * 大问题拆成两个子问题
        * 子问题的求解方式和大问题一样
        * 存在最小子问题（最后一个子问题就是最后一个节点，不需要反转单链表）
        *
        * 先递后归
        * */
        if(head == null || head.next == null){
            return head;
        }

        ListNode tmpNode = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return tmpNode;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}