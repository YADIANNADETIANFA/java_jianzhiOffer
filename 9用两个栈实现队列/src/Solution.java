import java.util.Stack;

public class Solution {
    private static Stack<Integer> a = new Stack<>();  //所以要直接在这里定义new ，不然会空指针异常
    private static Stack<Integer> b = new Stack<>();

/*    Solution(){
        a = new Stack<>();
        b = new Stack<>();
    }*/   //使用静态变量，这时候还没对象，构造函数还没来得及执行

    public static void appendTail(int num){
        a.push(num);
    }
    public static int deleteHead() throws Exception{
        if(b.isEmpty()) {
            if (a.isEmpty()) {
                throw new Exception("Invalid pop");
            }
            while (!a.isEmpty()) {
                b.push(a.pop());
            }
        }
        return b.pop();
    }
}
