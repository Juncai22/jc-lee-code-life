package 数学思维2;


/**
 * 237. 删除链表中的节点
 * LeeCode 237
 * 难度 ： 中等
 */
public class LeeCode237 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
