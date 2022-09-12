package 暴力拆解;


/**
 * 442. 数组中重复的数据
 * LeeCode 442
 * 难度 ： 中等
 */
public class LeeCode2181 {

    public ListNode mergeNodes(ListNode head) {
        ListNode listNode = new ListNode(0);
        ListNode next = null, cur = listNode;
        while (head.next != null) {
            next = head.next;
            if (next.val != 0) {
                cur.val += next.val;
            } else {
                if (head.next.next != null) {
                    ListNode node = new ListNode(0);
                    cur.next = node;
                    cur = cur.next;
                }
            }
            head = next;
        }
        return listNode;
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
