import java.util.ArrayList;
import java.util.Stack;

public class Solution1 {
    public static Stack<Integer> getStack(ListNode head){
        Stack<Integer> res = new Stack<>();
        if(null == head){
            return res;
        }
        while(null != head){
            res.push(head.val);
            head = head.next;
        }
        return res;
    }
}
//栈实现
