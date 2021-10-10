import java.util.LinkedList;

public class Solution {
    public static ListNode deleteNode(ListNode head, ListNode deleteNode) {
        if (null == head) {
            return null;
        }
        if (null == deleteNode) {
            return head;
        }
        if (head == deleteNode) {
            ListNode res = head.next;
            head.next = null;   //将删除的节点从链表中脱离，方便gc
            return res;
        }
        if (null == deleteNode.next) {
            ListNode node = head;
            while (node.next != deleteNode) {
                node = node.next;
            }
            node.next = null;
            return head;
        }
        ListNode deleteNext = deleteNode.next;
        deleteNode.val = deleteNext.val;
        deleteNode.next = deleteNext.next;
        deleteNext.next = null; //将删除的节点从链表中脱离，方便gc
        return head;
    }
}

/*
* 整体思路就是将下一个节点的值赋值给原本要删除的节点，进而删除下一个节点即可
* 要删除节点本题假定一定是链表中的某一节点，不会链表不存在该节点
* gc:   简单节点脱离链表就会被gc
* https://www.jb51.net/article/182855.htm
* https://www.cnblogs.com/zhengxc0325/p/14065662.html
* */