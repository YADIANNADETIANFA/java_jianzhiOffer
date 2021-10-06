import java.util.Stack;

public class Solution {
    private static Stack<Integer> a;
    private static Stack<Integer> b;

    static {
        a = new Stack<>();
        b = new Stack<>();
    }

    public static void addToTail(int num) {
        a.push(num);
    }

    public static int outFromHead() {
        if (b.isEmpty()) {
            if (a.isEmpty()) {
                return -1;  //“队列”内已无数据
            } else {
                while (!a.isEmpty()) {
                    b.push(a.pop());
                }
                return b.pop();
            }
        } else {
            return b.pop();
        }
    }
}
