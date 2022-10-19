package 线性表;


import java.util.List;

/**
 * 面试题 02.02. 返回倒数第 k 个节点
 * LeeCode 2701
 * 难度 ： 简单
 */
public class LeeCode2701 {


    public int kthToLast(ListNode head, int k) {
        //快慢指针
        ListNode mans = head;

        for (int i = 0; i < k - 1; i++) {
            head = head.next;
        }
        while (head.next != null) {
            head = head.next;
            mans = mans.next;
        }

        return mans.val;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

