package 线性表;


import java.util.HashSet;
import java.util.Set;

/**
 * 817. 链表组件
 * LeeCode 817
 * 难度 ： 中等
 */
public class LeeCode817 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(3);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(0);
        listNode.next.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(2);
        numComponents(listNode,new int[]{4});


    }

    public static int numComponents(ListNode head, int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        //设置标志位，进行检验
        boolean mean = false;
        //查看是否为第一个的单null，如果为，那么看结果
        if (head.next == null) {
            if (nums[0] == head.val) return 1;
            else return 0;
        }
        //将数据里面的东西全部载入，只有单一位数字
        for (int num : nums) {
            set.add(num);
        }
        while (head != null) {
            //如果包含则改变标志位,证明前面有数字，可以加一
            if (set.contains(head.val)) mean = true;
            //如果到了没有的，则断了一位数字，便清空标志位
            if ((mean && !set.contains(head.val)) || (mean && head.next == null)) {
                ans++;
                mean = false;
            }
            //进位
            head = head.next;
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
