package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution138 {

    // 暴力解
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // 第一次copy，将所有的点串起来
        Node tmp = head;
        Node preNode = null;
        Node newHead = null;
        Map<Node, Node> hash = new HashMap<>();
        while (tmp != null) {
            Node node = new Node(tmp.val);
            if (preNode != null) {
                preNode.next = node;
                preNode = node;
            } else {
                preNode = node;
                newHead = node;
            }
            hash.put(tmp, node);
            tmp = tmp.next;
        }

        // 第二次copy
        tmp = head;
        Node newTmp = newHead;
        while (tmp != null) {
            newTmp.random = hash.get(tmp.random);
            tmp = tmp.next;
            newTmp = newTmp.next;
        }

        return newHead;

    }
}
