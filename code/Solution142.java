package code;

import java.util.HashSet;
import java.util.Set;

public class Solution142 {

    // Hash表
    public ListNode detectCycle1(ListNode head) {
        /**
         * 时间复杂度：O(N)
         * 空间复杂度：O(N)
         */
        Set<ListNode> set = new HashSet<>();
        if (head == null) return null;
        while (head.next != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }

    // 快慢指针
    public ListNode detectCycle2(ListNode head) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next.next;
            if (fast == null) {
                return null;
            }
            slow = slow.next;
            if (fast == slow) {
                fast = head;
                while (fast != slow) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }
        return null;
    }

}
