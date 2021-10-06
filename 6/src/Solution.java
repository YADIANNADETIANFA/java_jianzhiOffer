import java.util.Stack;

public class Solution {
    public static Stack<Integer> getReverse(ListNode node1) {
        Stack<Integer> stack = new Stack<>();
        if (null == node1) {
            return stack;
        }
        ListNode node = node1;
        while (null != node) {
            stack.push(node.val);
            node = node.next;
        }
        return stack;
    }
}
