package code;

public class Solution21 {

    // 自己写的迭代
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode ans = new ListNode(0);
        ans.next = new ListNode(0);
        ListNode tmp = null;
        while (l1 != null && l2 != null) {
            if (tmp == null) tmp = ans.next;
            if (l1.val <= l2.val) {
                tmp.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                tmp.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        if (l1 == null) tmp.next = l2;
        if (l2 == null) tmp.next = l1;
        return ans.next.next;
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode ans = new ListNode(0);
        ListNode tmp = ans;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tmp.next = l1;
                l1 = l1.next;
            } else {
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
//        if (l1 == null) tmp.next = l2;
//        if (l2 == null) tmp.next = l1;
        tmp.next = l1 == null ? l2 : l1;
        return ans.next;
    }


    // 递归
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
