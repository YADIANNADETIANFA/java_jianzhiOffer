import java.util.LinkedList;

public class Solution {
    private static LinkedList<Integer> dequeA;
    private static LinkedList<Integer> dequeB;

    static {
        dequeA = new LinkedList<>();
        dequeB = new LinkedList<>();
    }

    public static void pushToTail(int num) throws Exception {
        if (!dequeA.isEmpty() && !dequeB.isEmpty()) {
            throw new Exception("Invalid situation");
        } else if (dequeA.isEmpty() && dequeB.isEmpty()) {
            dequeA.add(num);
        } else if (dequeA.isEmpty()) {
            dequeB.add(num);
        } else {
            dequeA.add(num);
        }
    }

    public static int popFromTail() throws Exception {
        if (!dequeA.isEmpty() && !dequeB.isEmpty()) {
            throw new Exception("Invalid situation");
        } else if (dequeA.isEmpty() && dequeB.isEmpty()) {
            throw new Exception("nothing in myStack");
        } else if (dequeA.isEmpty()) {
            while (dequeB.size() > 1) {
                dequeA.offer(dequeB.poll());
            }
            return dequeB.poll();
        } else {
            while (dequeA.size() > 1) {
                dequeB.offer(dequeA.poll());
            }
            return dequeA.poll();
        }
    }
}
