import java.util.ArrayList;

public class DemoApplication {
    public static void main(String[] args) {
        Solution.addToTail(0);
        Solution.addToTail(1);
        Solution.addToTail(2);
        Solution.addToTail(3);
        try{
            ArrayList<Integer> res = new ArrayList<>();
            res.add(Solution.outFromHead());
            res.add(Solution.outFromHead());
            res.add(Solution.outFromHead());
            res.add(Solution.outFromHead());
            res.add(Solution.outFromHead());
            for(var num:res){
                System.out.print(num);
                System.out.print(" ");
            }
            res.add(Solution.outFromHead());
        } catch(Exception e){
            System.out.print(e.getMessage());
        }
    }
}
