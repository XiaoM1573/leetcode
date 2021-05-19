package code;

import java.util.List;

// 反转链表
public class Solution206 {
    // 方法1：迭代
    public ListNode reverseList1(ListNode head) {
        /*
         *
         *
         * */
        ListNode preNode = null;
        ListNode curNode = head;
        while (curNode != null) {
            ListNode nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }

        return preNode;
    }

    // 方法2：递归
    public ListNode reverseList2(ListNode head) {
        return null;
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