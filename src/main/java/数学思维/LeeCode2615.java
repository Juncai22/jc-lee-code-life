package 数学思维;


import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 077. 链表排序
 * LeeCode 2615
 * 难度 ： 中等
 */
public class LeeCode2615 {

    public ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        list.sort(((o1, o2) -> o1 - o2));
        ListNode ans = null;
        if (list.size() != 0 && list.get(0) != null) {
            ans = new ListNode(list.get(0));
        }
        ListNode temp = ans;
        for (int i = 1; i < list.size(); i++) {
            ListNode listNode = new ListNode(list.get(i));
            temp.next = listNode;
            temp = listNode;
        }
        return ans;
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
