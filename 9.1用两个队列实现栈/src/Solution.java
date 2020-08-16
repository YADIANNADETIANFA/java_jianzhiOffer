import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    private static Deque<Integer> dequeA = new LinkedList<>();
    private static Deque<Integer> dequeB = new LinkedList<>();

    public static void myPush(int val){
        if(dequeA.isEmpty() && dequeB.isEmpty()){
            dequeA.offer(val);
        }else if(dequeA.isEmpty()){
            dequeB.offer(val);
        }else{
            dequeA.offer(val);
        }
    }
    public static int mayPop() throws Exception{
        if(dequeA.isEmpty() && dequeB.isEmpty()){
            throw new Exception("Invalid pop");
        }else if(dequeA.isEmpty()){
            while(dequeB.size()>1){
                dequeA.offer(dequeB.poll());
            }
            return dequeB.poll();
        }else{
            while(dequeA.size()>1){
                dequeB.offer(dequeA.poll());
            }
            return dequeA.poll();
        }
    }
}
