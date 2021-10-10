public class Solution {
    public static ListNode removeDuplicationNode (ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode preNode = null;
        ListNode pNode = pHead;
        while (pNode.next != null) {
            ListNode pNext = pNode.next;
            boolean isDuplicate = false;
            if (pNode.val == pNext.val) {
                isDuplicate = true;
            }
            if (!isDuplicate) {
                preNode = pNode;
                pNode = pNext;
            } else {
                int val = pNode.val;
                while (pNext.next != null && pNext.val == val) {
                    pNode.next = null;
                    pNode = pNext;
                    pNext = pNext.next;
                }
                if (pNode.val != pNext.val) {
                    pNode.next = null;
                    pNode = pNext;
                    if (preNode != null) {
                        preNode.next = pNode;
                    } else {
                        pHead = pNode;
                    }
                } else {
                    pNode.next = null;
                    pNext.next = null;
                    if (preNode != null) {
                        preNode.next = null;
                    } else {
                        return null;
                    }
                }
            }
        }
        return pHead;
    }
}
