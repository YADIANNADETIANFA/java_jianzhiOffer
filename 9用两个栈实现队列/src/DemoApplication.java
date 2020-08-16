import java.util.ArrayList;

public class DemoApplication {
    public static void main(String args[]){
        Solution.appendTail(0);
        Solution.appendTail(1);
        Solution.appendTail(2);
        Solution.appendTail(3);
        try{
            ArrayList<Integer> res = new ArrayList<>();  //Stack，ArrayList要用Integer而不是int，要的是引用，里面存的是对象，不是基本数据类型int
            res.add(Solution.deleteHead());
            res.add(Solution.deleteHead());
            res.add(Solution.deleteHead());
            res.add(Solution.deleteHead());
            for(var num:res){
                System.out.print(num);
                System.out.print(" ");
            }
            res.add(Solution.deleteHead());
        } catch(Exception e){
            System.out.print(e.getMessage());
        }
    }
}
