package code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution82 {
    // hash表，针对无序
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        Map<Integer, Boolean> hashTable = new HashMap<>();
        ListNode tmp = head;
        ListNode preNode = head;
        // 一次遍历
        while (tmp != null) {
            if (hashTable.containsKey(tmp.val)) {
                hashTable.put(tmp.val, true);
                preNode.next = tmp.next;
                tmp = tmp.next;
                continue;
            }
            hashTable.put(tmp.val, false);
            preNode = tmp;
            tmp = tmp.next;
        }

        // 二次遍历
        while (head != null) {
            if (hashTable.get(head.val)) {
                head = head.next;
            } else {
                break;
            }
        }

        tmp = head;
        preNode = head;
        while (tmp != null) {
            if (hashTable.get(tmp.val)) {
                preNode.next = tmp.next;
                tmp = tmp.next;
            } else {
                preNode = tmp;
                tmp = tmp.next;
            }
        }
        return head;
    }

    // 有序
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) return null;
        ListNode preNode = null;
        while (head != null) {
            if (head.val != preNode.val) {
                preNode = head;
                head = head.next;
            }

        }
        return null;
    }

}
